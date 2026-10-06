package com.briup.pai.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.common.constant.CommonConstant;
import com.briup.pai.common.constant.DatasetConstant;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.convert.ClassifyConvert;
import com.briup.pai.dao.ClassifyMapper;
import com.briup.pai.entity.dto.ClassifySaveDTO;
import com.briup.pai.entity.po.Classify;
import com.briup.pai.entity.po.Entity;
import com.briup.pai.entity.vo.ClassifyEchoVO;
import com.briup.pai.entity.vo.ClassifyInDatasetVO;
import com.briup.pai.service.IClassifyService;
import com.briup.pai.service.IEntityService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
@CacheConfig(cacheNames = DatasetConstant.DATASET_CACHE_PREFIX)
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {

    @Resource
    private ClassifyConvert classifyConvert;

    @Resource
    private IEntityService entityService;

    @Value("${upload.nginx-file-path}")
    private String nginxFilePath;

    @Override
    public List<ClassifyInDatasetVO> getClassifiesByDatasetId(Integer datasetId) {
        LambdaQueryWrapper<Classify> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Classify::getDatasetId, datasetId);
        return classifyConvert.po2ClassifyInDatasetVOList(this.list(wrapper))
                .stream()
                .peek(vo -> vo.setEntityNum((long) entityService.getEntityByClassifyId(vo.getClassifyId()).size()))
                .toList();
    }

    @Override
    @Transactional
    @CachePut(key = "T(com.briup.pai.common.constant.DatasetConstant).DATASET_CLASSIFY_CACHE_PREFIX + ':' + #result.classifyId")
    @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DETAIL_CACHE_PREFIX + ':' + #dto.getDatasetId()")
    public ClassifyEchoVO addOrModifyClassify(ClassifySaveDTO dto) {
        Integer classifyId = dto.getClassifyId();
        Integer datasetId = dto.getDatasetId();
        String classifyName = dto.getClassifyName();
        Classify classify;
        if (ObjectUtil.isNull(classifyId)) {
            // 新增：分类名称必须唯一（和当前数据集下的其他名称不一致即可）
            LambdaQueryWrapper<Classify> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Classify::getDatasetId, datasetId).eq(Classify::getClassifyName, classifyName);
            BriupAssert.requireNull(this.getOne(wrapper), ResultCodeEnum.DATA_ALREADY_EXIST);
            // 转换po添加
            classify = classifyConvert.classifySaveDTO2Po(dto);
            this.save(classify);
            // 创建该分类的文件夹
            File file = new File(this.nginxFilePath + "/" + datasetId + "/" + classifyName);
            FileUtil.mkdir(file);
        } else {
            // 修改：分类必须存在
            Classify temp = BriupAssert.requireNotNull(this, Classify::getId, classifyId, ResultCodeEnum.DATA_NOT_EXIST);
            // 分类名称必须唯一
            LambdaQueryWrapper<Classify> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Classify::getDatasetId, datasetId)
                    .eq(Classify::getClassifyName, classifyName)
                    .ne(Classify::getId, classifyId);
            BriupAssert.requireNull(this.getOne(wrapper), ResultCodeEnum.DATA_ALREADY_EXIST);
            // 数据集ID不能修改
            BriupAssert.requireEqual(temp.getDatasetId(), datasetId, ResultCodeEnum.PARAM_IS_ERROR);
            // 转换po修改
            classify = classifyConvert.classifySaveDTO2Po(dto);
            this.updateById(classify);
            // 同步修改nginx目录下文件夹名称
            File file = new File(this.nginxFilePath + "/" + temp.getDatasetId() + "/" + temp.getClassifyName());
            FileUtil.rename(file, dto.getClassifyName(), true);
        }
        return classifyConvert.po2ClassifyEchoVO(classify);
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(key = "T(com.briup.pai.common.constant.DatasetConstant).DATASET_CLASSIFY_CACHE_PREFIX + ':' + #classifyId"),
            @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DETAIL_CACHE_PREFIX + ':' + #datasetId")
    })
    public void removeClassifyById(Integer datasetId, Integer classifyId) {
        // 分类必须存在
        Classify classify = BriupAssert.requireNotNull(this, Classify::getId, classifyId, ResultCodeEnum.DATA_NOT_EXIST);
        // 数据集ID必须一致
        BriupAssert.requireEqual(datasetId, classify.getDatasetId(), ResultCodeEnum.PARAM_IS_ERROR);
        // 获取分类下所有待删除的实体编号
        LambdaQueryWrapper<Entity> entityWrapper = new LambdaQueryWrapper<>();
        entityWrapper.eq(Entity::getClassifyId, classifyId);
        List<Integer> entityIds = entityService.list(entityWrapper).stream().map(Entity::getId).toList();
        // 删除实体
        entityService.removeBatchByIds(entityIds);
        // 删除分类
        this.removeById(classifyId);
        // 删除该分类的文件夹
        String classifyFilePath = this.nginxFilePath + "/" + classify.getDatasetId() + "/" + classify.getClassifyName();
        FileUtil.del(classifyFilePath);
    }

    @Override
    @Cacheable(key = "T(com.briup.pai.common.constant.DatasetConstant).DATASET_CLASSIFY_CACHE_PREFIX + ':' + #classifyId")
    public ClassifyEchoVO getClassifyById(Integer classifyId) {
        Classify classify = BriupAssert.requireNotNull(this, Classify::getId, classifyId, ResultCodeEnum.DATA_NOT_EXIST);
        return classifyConvert.po2ClassifyEchoVO(classify);
    }
}
