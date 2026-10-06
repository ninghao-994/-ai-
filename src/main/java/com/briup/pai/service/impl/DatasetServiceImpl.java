package com.briup.pai.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.common.constant.CommonConstant;
import com.briup.pai.common.constant.DatasetConstant;
import com.briup.pai.common.enums.DatasetStatusEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.convert.DatasetConvert;
import com.briup.pai.dao.DatasetMapper;
import com.briup.pai.entity.dto.DatasetSaveDTO;
import com.briup.pai.entity.po.Classify;
import com.briup.pai.entity.po.Dataset;
import com.briup.pai.entity.po.Entity;
import com.briup.pai.entity.vo.ClassifyInDatasetVO;
import com.briup.pai.entity.vo.DatasetDetailVO;
import com.briup.pai.entity.vo.DatasetEchoVO;
import com.briup.pai.entity.vo.DatasetPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IClassifyService;
import com.briup.pai.service.IDatasetService;
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
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = DatasetConstant.DATASET_CACHE_PREFIX)
public class DatasetServiceImpl extends ServiceImpl<DatasetMapper, Dataset> implements IDatasetService {

    @Resource
    private DatasetConvert datasetConvert;

    @Resource
    private IClassifyService classifyService;

    @Resource
    private IEntityService entityService;

    @Value("${upload.nginx-file-path}")
    private String nginxFilePath;

    @Override
    public PageVO<DatasetPageVO> getDatasetByPageAndCondition(Long pageNum, Long pageSize, String datasetName, Integer datasetType) {
        // 开启分页
        Page<Dataset> page = new Page<>(pageNum, pageSize);
        // 条件分页查询
        LambdaQueryWrapper<Dataset> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(datasetName), Dataset::getDatasetName, datasetName)
                .eq(ObjectUtil.isNotNull(datasetType), Dataset::getDatasetType, datasetType)
                .orderByDesc(Dataset::getCreateTime);
        Page<Dataset> pageInfo = this.page(page, wrapper);
        // 封装PageVO对象，并统计每个数据集下的分类数量与实体数量
        PageVO<DatasetPageVO> pageVO = new PageVO<>();
        pageVO.setTotal(pageInfo.getTotal());
        List<DatasetPageVO> vos = datasetConvert.po2DatasetPageVOList(pageInfo.getRecords())
                .stream()
                .peek(datasetPageVO -> {
                    Integer datasetId = datasetPageVO.getDatasetId();
                    List<ClassifyInDatasetVO> list = classifyService.getClassifiesByDatasetId(datasetId);
                    datasetPageVO.setClassifyNum((long) list.size());
                    long entityNum = 0L;
                    for (ClassifyInDatasetVO classify : list) {
                        entityNum += classify.getEntityNum();
                    }
                    datasetPageVO.setEntityNum(entityNum);
                })
                .toList();
        pageVO.setData(vos);
        return pageVO;
    }

    @Override
    @Transactional
    @CachePut(key = "#result.datasetId")
    @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DETAIL_CACHE_PREFIX + ':' + #dto.getDatasetId()", condition = "#dto.getDatasetId() != null")
    public DatasetEchoVO addOrModifyDataset(DatasetSaveDTO dto) {
        Integer datasetId = dto.getDatasetId();
        Dataset dataset;
        if (ObjectUtil.isNull(datasetId)) {
            // 新增：数据集名称必须唯一
            BriupAssert.requireNull(this, Dataset::getDatasetName, dto.getDatasetName(), ResultCodeEnum.DATA_ALREADY_EXIST);
            // 转换成po对象
            dataset = datasetConvert.datasetSaveDTO2Po(dto);
            // 数据集状态设置为初始化
            dataset.setDatasetStatus(DatasetStatusEnum.INIT.getStatus());
            this.save(dataset);
        } else {
            // 修改：数据集必须存在
            Dataset temp = BriupAssert.requireNotNull(this, Dataset::getId, datasetId, ResultCodeEnum.DATA_NOT_EXIST);
            // 数据集名称必须唯一
            BriupAssert.requireNull(this, Dataset::getDatasetName, dto.getDatasetName(), Dataset::getId, datasetId, ResultCodeEnum.DATA_ALREADY_EXIST);
            // 数据集类型不能修改
            BriupAssert.requireEqual(dto.getDatasetType(), temp.getDatasetType(), ResultCodeEnum.PARAM_IS_ERROR);
            // 修改
            dataset = datasetConvert.datasetSaveDTO2Po(dto);
            this.updateById(dataset);
        }
        return datasetConvert.po2DatasetEchoVO(dataset);
    }

    @Override
    @Cacheable(key = "#datasetId")
    public DatasetEchoVO modifyDatasetFeedback(Integer datasetId) {
        // 数据集必须存在
        Dataset dataset = BriupAssert.requireNotNull(this, Dataset::getId, datasetId, ResultCodeEnum.DATA_NOT_EXIST);
        return datasetConvert.po2DatasetEchoVO(dataset);
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(key = "#datasetId"),
            @CacheEvict(key = "T(com.briup.pai.common.constant.CommonConstant).DETAIL_CACHE_PREFIX + ':' + #datasetId")
    })
    public void removeDatasetById(Integer datasetId) {
        // 数据集必须存在
        BriupAssert.requireNotNull(this, Dataset::getId, datasetId, ResultCodeEnum.DATA_NOT_EXIST);
        // 查询需要删除的分类编号集合
        LambdaQueryWrapper<Classify> classifyWrapper = new LambdaQueryWrapper<>();
        classifyWrapper.eq(Classify::getDatasetId, datasetId);
        List<Integer> classifyIds = classifyService.list(classifyWrapper).stream().map(Classify::getId).toList();
        // 查询需要删除的实体编号集合
        List<Integer> entityIds = new ArrayList<>();
        for (Integer classifyId : classifyIds) {
            LambdaQueryWrapper<Entity> entityWrapper = new LambdaQueryWrapper<>();
            entityWrapper.eq(Entity::getClassifyId, classifyId);
            entityIds.addAll(entityService.list(entityWrapper).stream().map(Entity::getId).toList());
        }
        // 删除所有实体记录
        entityService.removeBatchByIds(entityIds);
        // 删除所有分类记录
        classifyService.removeBatchByIds(classifyIds);
        // 删除数据集
        this.removeById(datasetId);
        // 删除对应文件夹
        FileUtil.del(this.nginxFilePath + "/" + datasetId);
    }

    @Override
    @Cacheable(key = "T(com.briup.pai.common.constant.CommonConstant).DETAIL_CACHE_PREFIX + ':' + #datasetId")
    public DatasetDetailVO getDatasetDetail(Integer datasetId) {
        // 数据集必须存在
        Dataset dataset = BriupAssert.requireNotNull(this, Dataset::getId, datasetId, ResultCodeEnum.DATA_NOT_EXIST);
        // 转成VO对象
        DatasetDetailVO datasetDetailVO = datasetConvert.po2DatasetDetailVO(dataset);
        // 设置分类数量和分类
        List<ClassifyInDatasetVO> list = classifyService.getClassifiesByDatasetId(datasetId);
        datasetDetailVO.setClassifies(list);
        datasetDetailVO.setClassifyNum((long) list.size());
        // 设置实体数量
        long entityNum = 0L;
        for (ClassifyInDatasetVO classify : list) {
            entityNum += classify.getEntityNum();
        }
        datasetDetailVO.setEntityNum(entityNum);
        return datasetDetailVO;
    }
}
