package com.briup.pai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.common.constant.CommonConstant;
import com.briup.pai.common.constant.DictionaryConstant;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.convert.DictionaryConvert;
import com.briup.pai.dao.DictionaryMapper;
import com.briup.pai.entity.dto.DictionarySaveDTO;
import com.briup.pai.entity.po.Dictionary;
import com.briup.pai.entity.vo.DictionaryEchoVO;
import com.briup.pai.entity.vo.DictionaryPageVO;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IDictionaryService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = DictionaryConstant.DICTIONARY_CACHE_PREFIX)
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

    @Resource
    private DictionaryConvert dictionaryConvert;

    @Override
    @Transactional
    @CachePut(key = "#result.dictId")
    public DictionaryEchoVO addOrModifyDictionary(DictionarySaveDTO dto) {
        Integer dictId = dto.getDictId();
        String dictCode = dto.getDictCode();
        Integer parentId = dto.getParentId();
        Dictionary saveData;
        if (ObjectUtil.isNull(dictId)) {
            // 新增：数据字典编码不能重复
            BriupAssert.requireNull(this, Dictionary::getDictCode, dictCode, ResultCodeEnum.DATA_ALREADY_EXIST);
            // 父id合法：0或者已存在的父id
            BriupAssert.requireIn(parentId, getParentDictIdList(), ResultCodeEnum.PARAM_IS_ERROR);
            // 保存
            saveData = dictionaryConvert.dictionarySaveDTO2PO(dto);
            this.save(saveData);
        } else {
            // 修改：数据字典必须存在
            Dictionary dictionary = requireDictionaryExist(dictId);
            // 编码不能修改
            BriupAssert.requireEqual(dictCode, dictionary.getDictCode(), ResultCodeEnum.PARAM_IS_ERROR);
            // 修改
            saveData = dictionaryConvert.dictionarySaveDTO2PO(dto);
            this.updateById(saveData);
        }
        // 返回保存后的VO数据
        return dictionaryConvert.po2DictionaryEchoVO(saveData);
    }

    @Override
    @Cacheable(key = "#dictionaryId")
    public DictionaryEchoVO getDictionaryById(Integer dictionaryId) {
        Dictionary dictionary = requireDictionaryExist(dictionaryId);
        return dictionaryConvert.po2DictionaryEchoVO(dictionary);
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public void removeDictionaryById(Integer dictionaryId) {
        Dictionary dictionary = requireDictionaryExist(dictionaryId);
        if (ObjectUtil.equal(dictionary.getParentId(), DictionaryConstant.PARENT_DICTIONARY_ID)) {
            // 删除一级字典：同步删除该字典下的所有二级字典
            LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Dictionary::getParentId, dictionaryId);
            this.remove(wrapper);
            // 删除父字典
            this.removeById(dictionaryId);
        } else {
            // 删除二级字典
            this.removeById(dictionaryId);
            // 一级字典下没有子数据时，同步删除一级字典
            LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Dictionary::getParentId, dictionary.getParentId());
            List<Dictionary> dictionaryList = this.list(wrapper);
            if (ObjectUtil.isEmpty(dictionaryList)) {
                this.removeById(dictionary.getParentId());
            }
        }
    }

    @Override
    public PageVO<DictionaryPageVO> getDictionaryByPage(Long pageNum, Long pageSize) {
        // 开启分页
        Page<Dictionary> page = new Page<>(pageNum, pageSize);
        // 分页查询所有一级数据字典
        LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dictionary::getParentId, DictionaryConstant.PARENT_DICTIONARY_ID);
        Page<Dictionary> pageResult = this.page(page, wrapper);
        // 转换VO
        List<DictionaryPageVO> parentDictionary = dictionaryConvert.po2DictionaryPageVOList(pageResult.getRecords());
        // 遍历集合，挂载二级数据字典
        parentDictionary.forEach(item -> {
            LambdaQueryWrapper<Dictionary> childWrapper = new LambdaQueryWrapper<>();
            childWrapper.eq(Dictionary::getParentId, item.getDictId());
            List<DictionaryPageVO> children = dictionaryConvert.po2DictionaryPageVOList(this.list(childWrapper));
            item.setChildren(children);
        });
        PageVO<DictionaryPageVO> pageVO = new PageVO<>();
        pageVO.setTotal(pageResult.getTotal());
        pageVO.setData(parentDictionary);
        return pageVO;
    }

    @Override
    @Cacheable(key = "T(com.briup.pai.common.constant.CommonConstant).DROPDOWN_CACHE_PREFIX + ':' + #dictCode", unless = "#result == null")
    public List<DropDownVO> getDropDownList(String dictCode) {
        // 校验dictCode是否有效且为一级数据字典编码
        LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dictionary::getDictCode, dictCode);
        Dictionary dictionary = this.getOne(wrapper);
        BriupAssert.requireNotNull(dictionary, ResultCodeEnum.DATA_NOT_EXIST);
        BriupAssert.requireEqual(dictionary.getParentId(), DictionaryConstant.PARENT_DICTIONARY_ID, ResultCodeEnum.PARAM_IS_ERROR);
        // 查询所有子字典
        wrapper.clear();
        wrapper.eq(Dictionary::getParentId, dictionary.getId());
        List<Dictionary> list = this.list(wrapper);
        return dictionaryConvert.po2DictionaryDropDownVOList(list);
    }

    @Override
    public String getDictionaryValueById(Integer dictionaryId) {
        Dictionary dictionary = this.getById(dictionaryId);
        return dictionary == null ? null : dictionary.getDictValue();
    }

    /**
     * 获取所有父数据字典的编号集合（含0）
     */
    private List<Integer> getParentDictIdList() {
        LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dictionary::getParentId, DictionaryConstant.PARENT_DICTIONARY_ID);
        List<Integer> collect = this.list(wrapper).stream()
                .map(Dictionary::getId)
                .collect(Collectors.toList());
        collect.add(DictionaryConstant.PARENT_DICTIONARY_ID);
        return collect;
    }

    /**
     * 数据字典必须存在
     */
    private Dictionary requireDictionaryExist(Integer dictionaryId) {
        return BriupAssert.requireNotNull(this, Dictionary::getId, dictionaryId, ResultCodeEnum.DATA_NOT_EXIST);
    }
}
