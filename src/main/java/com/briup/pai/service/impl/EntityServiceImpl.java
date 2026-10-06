package com.briup.pai.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.common.constant.CommonConstant;
import com.briup.pai.common.constant.DatasetConstant;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.convert.EntityConvert;
import com.briup.pai.dao.EntityMapper;
import com.briup.pai.entity.po.Classify;
import com.briup.pai.entity.po.Dataset;
import com.briup.pai.entity.po.Entity;
import com.briup.pai.entity.vo.EntityInClassifyVO;
import com.briup.pai.entity.vo.EntityPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IClassifyService;
import com.briup.pai.service.IDatasetService;
import com.briup.pai.service.IEntityService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = DatasetConstant.DATASET_CACHE_PREFIX)
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements IEntityService {

    @Resource
    private EntityConvert entityConvert;

    @Resource
    @Lazy  // 解决循环依赖
    private IDatasetService datasetService;

    @Resource
    @Lazy  // 解决循环依赖
    private IClassifyService classifyService;

    @Value("${upload.nginx-server}")
    private String nginxServer;

    @Value("${upload.nginx-file-path}")
    private String nginxFilePath;

    @Override
    public List<EntityInClassifyVO> getEntityByClassifyId(Integer classifyId) {
        LambdaQueryWrapper<Entity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Entity::getClassifyId, classifyId);
        return entityConvert.po2EntityInClassifyVOList(this.list(wrapper));
    }

    @Override
    public PageVO<EntityPageVO> getEntityByPage(Integer classifyId, Long pageNum) {
        // 分类必须存在
        BriupAssert.requireNotNull(classifyService, Classify::getId, classifyId, ResultCodeEnum.DATA_NOT_EXIST);
        // 分页查询实体
        Page<Entity> page = new Page<>(pageNum, DatasetConstant.ENTITY_PAGE_SIZE);
        LambdaQueryWrapper<Entity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Entity::getClassifyId, classifyId);
        Page<Entity> pageInfo = this.page(page, wrapper);
        // 拼接图片展示路径（http://localhost:89/${datasetId}/${classifyName}/${entityUrl}）
        List<Entity> records = pageInfo.getRecords()
                .stream()
                .peek(entity -> {
                    String entityUrl = entity.getEntityUrl();
                    Classify classify = classifyService.getById(entity.getClassifyId());
                    Integer datasetId = classify.getDatasetId();
                    String classifyName = classify.getClassifyName();
                    entity.setEntityUrl(CommonConstant.createEntityPath(this.nginxServer, datasetId, classifyName, entityUrl));
                })
                .toList();
        PageVO<EntityPageVO> pageVO = new PageVO<>();
        pageVO.setTotal(pageInfo.getTotal());
        pageVO.setData(entityConvert.po2EntityPageVOList(records));
        return pageVO;
    }

    @Override
    @Transactional
    @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DETAIL_CACHE_PREFIX + ':' + #datasetId")
    public void removeEntityByBatch(Integer datasetId, Integer classifyId, List<Integer> entityIds) {
        // 数据集必须存在
        BriupAssert.requireNotNull(datasetService, Dataset::getId, datasetId, ResultCodeEnum.DATA_NOT_EXIST);
        // 分类必须存在
        Classify classify = BriupAssert.requireNotNull(classifyService, Classify::getId, classifyId, ResultCodeEnum.DATA_NOT_EXIST);
        // 分类所属数据集必须一致
        BriupAssert.requireEqual(classify.getDatasetId(), datasetId, ResultCodeEnum.PARAM_IS_ERROR);
        // 获取所有实体图片对应的文件路径
        List<String> entityUrls = entityIds.stream()
                .map(entityId -> CommonConstant.createEntityPath(
                        this.nginxFilePath,
                        datasetId,
                        classify.getClassifyName(),
                        this.getById(entityId).getEntityUrl()))
                .toList();
        // 批量删除图片
        this.removeBatchByIds(entityIds);
        // 删除文件
        entityUrls.forEach(url -> FileUtil.del(url));
    }
}
