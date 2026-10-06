package com.briup.pai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.common.constant.CommonConstant;
import com.briup.pai.common.constant.OperatorConstant;
import com.briup.pai.common.enums.OperatorCategoryEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.common.exception.CustomException;
import com.briup.pai.convert.OperatorConvert;
import com.briup.pai.dao.OperatorMapper;
import com.briup.pai.entity.dto.OperatorImportDTO;
import com.briup.pai.entity.dto.OperatorUpdateDTO;
import com.briup.pai.entity.po.Operator;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.OperatorEchoVO;
import com.briup.pai.entity.vo.OperatorPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IOperatorService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = OperatorConstant.OPERATOR_CACHE_PREFIX)
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements IOperatorService {

    @Resource
    private OperatorConvert operatorConvert;

    @Autowired
    @Lazy  // 自注入代理，解决循环引用，同时保证同类方法调用时事务生效
    private IOperatorService operatorService;

    @Override
    @Transactional
    @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DROPDOWN_CACHE_PREFIX")
    public void importOperator(MultipartFile file) {
        // 校验文件类型 xlsx xls
        BriupAssert.requireExcel(file);
        // 查询所有算子名称（用于过滤掉名称已存在的算子）
        List<String> operatorNames = this.list().stream()
                .map(Operator::getOperatorName)
                .collect(Collectors.toList());
        // 导入的数据
        List<OperatorImportDTO> operators = new ArrayList<>();
        try {
            EasyExcel.read(file.getInputStream(), OperatorImportDTO.class, new AnalysisEventListener<OperatorImportDTO>() {
                @Override
                public void invoke(OperatorImportDTO operatorImportDTO, AnalysisContext analysisContext) {
                    if (!ObjectUtil.contains(operatorNames, operatorImportDTO.getOperatorName())) {
                        // 添加名称不存在的算子
                        operatorNames.add(operatorImportDTO.getOperatorName());
                        operators.add(operatorImportDTO);
                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    // 过滤异常数据（算子分类/类型不存在的数据转换结果为-1）
                    List<Operator> list = operatorConvert.operatorImportDto2PoList(operators).stream()
                            .filter(operator -> operator.getOperatorType() != -1 && operator.getOperatorCategory() != -1)
                            .toList();
                    // 批量保存（通过自注入代理调用，保证事务生效）
                    operatorService.saveBatch(list);
                }
            }).sheet(0).doRead();
        } catch (IOException e) {
            throw new CustomException(ResultCodeEnum.FILE_IMPORT_ERROR);
        }
    }

    @Override
    public PageVO<OperatorPageVO> getOperatorByPageAndCondition(Long pageNum, Long pageSize, Integer operatorType, Integer operatorCategory) {
        // 开启分页
        Page<Operator> page = new Page<>(pageNum, pageSize);
        // 条件查询算子信息
        LambdaQueryWrapper<Operator> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(operatorType != -1, Operator::getOperatorType, operatorType);
        wrapper.eq(operatorCategory != -1, Operator::getOperatorCategory, operatorCategory);
        Page<Operator> pageInfo = this.page(page, wrapper);
        // 封装PageVO对象
        PageVO<OperatorPageVO> pageVO = new PageVO<>();
        pageVO.setTotal(pageInfo.getTotal());
        pageVO.setData(operatorConvert.po2OperatorPageVOList(pageInfo.getRecords()));
        return pageVO;
    }

    @Override
    @Cacheable(key = "#operatorId")
    public OperatorEchoVO getOperatorById(Integer operatorId) {
        Operator operator = requireOperatorExist(operatorId);
        return operatorConvert.po2OperatorEchoVO(operator);
    }

    @Override
    @Transactional
    @CachePut(key = "#dto.operatorId")
    @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DROPDOWN_CACHE_PREFIX")
    public OperatorEchoVO modifyOperatorById(OperatorUpdateDTO dto) {
        // 算子必须存在
        requireOperatorExist(dto.getOperatorId());
        // 算子名称不能重复
        BriupAssert.requireNull(this, Operator::getOperatorName, dto.getOperatorName(), Operator::getId, dto.getOperatorId(), ResultCodeEnum.DATA_ALREADY_EXIST);
        // 转换成PO修改
        Operator operator = operatorConvert.operatorUpdateDTO2po(dto);
        this.updateById(operator);
        return operatorConvert.po2OperatorEchoVO(operator);
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(key = "#operatorId"),
            @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DROPDOWN_CACHE_PREFIX")
    })
    public void removeOperatorById(Integer operatorId) {
        requireOperatorExist(operatorId);
        this.removeById(operatorId);
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public void removeOperatorByIds(List<Integer> ids) {
        this.removeBatchByIds(ids);
    }

    @Override
    @Cacheable(key = "T(com.briup.pai.common.constant.CommonConstant).DROPDOWN_CACHE_PREFIX")
    public Map<Integer, List<DropDownVO>> getOperatorDropDownList() {
        Map<Integer, List<DropDownVO>> map = new HashMap<>();
        // 按算子分类封装下拉框数据
        OperatorCategoryEnum.categoryList().forEach(category -> {
            LambdaQueryWrapper<Operator> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Operator::getOperatorCategory, category);
            List<DropDownVO> dropDownVOS = operatorConvert.po2DropDownList(this.list(wrapper));
            map.put(category, dropDownVOS);
        });
        return map;
    }

    /**
     * 算子必须存在
     */
    private Operator requireOperatorExist(Integer operatorId) {
        return BriupAssert.requireNotNull(this, Operator::getId, operatorId, ResultCodeEnum.DATA_NOT_EXIST);
    }
}
