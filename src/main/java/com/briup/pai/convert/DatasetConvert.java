package com.briup.pai.convert;

import cn.hutool.core.util.ObjectUtil;
import com.briup.pai.common.enums.DatasetStatusEnum;
import com.briup.pai.common.enums.DatasetUsageEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.CustomException;
import com.briup.pai.entity.dto.DatasetSaveDTO;
import com.briup.pai.entity.po.Dataset;
import com.briup.pai.entity.vo.DatasetDetailVO;
import com.briup.pai.entity.vo.DatasetEchoVO;
import com.briup.pai.entity.vo.DatasetPageVO;
import com.briup.pai.entity.vo.TrainingDatasetQueryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DatasetConvert {

    // Dataset -> DatasetPageVO
    @Mapping(target = "datasetId", source = "id")
    @Mapping(target = "datasetType", expression = "java(BaseConvert.INSTANCE.getDictionaryValue(dataset.getDatasetType()))")
    @Mapping(target = "datasetStatus", qualifiedByName = "getDatasetStatus")
    @Mapping(target = "datasetUsage", qualifiedByName = "getDatasetUsage")
    @Mapping(target = "entityNum", ignore = true)
    @Mapping(target = "classifyNum", ignore = true)
    DatasetPageVO po2DatasetPageVO(Dataset dataset);

    // List<Dataset> -> List<DatasetPageVO>
    List<DatasetPageVO> po2DatasetPageVOList(List<Dataset> datasets);

    @Named("getDatasetStatus")
    default String getDatasetStatus(Integer datasetStatus) {
        if (ObjectUtil.equal(datasetStatus, DatasetStatusEnum.INIT.getStatus())) {
            return DatasetStatusEnum.INIT.getDesc();
        } else if (ObjectUtil.equal(datasetStatus, DatasetStatusEnum.UPLOADING.getStatus())) {
            return DatasetStatusEnum.UPLOADING.getDesc();
        } else if (ObjectUtil.equal(datasetStatus, DatasetStatusEnum.DONE.getStatus())) {
            return DatasetStatusEnum.DONE.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    @Named("getDatasetUsage")
    default String getDatasetUsage(Integer datasetUsage) {
        if (ObjectUtil.equal(datasetUsage, DatasetUsageEnum.INIT.getUsage())) {
            return DatasetUsageEnum.INIT.getDesc();
        } else if (ObjectUtil.equal(datasetUsage, DatasetUsageEnum.OPTIMIZE.getUsage())) {
            return DatasetUsageEnum.OPTIMIZE.getDesc();
        } else if (ObjectUtil.equal(datasetUsage, DatasetUsageEnum.EVALUATE.getUsage())) {
            return DatasetUsageEnum.EVALUATE.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    // DatasetSaveDTO -> Dataset
    @Mapping(target = "id", source = "datasetId")
    @Mapping(target = "createBy", expression = "java(BaseConvert.INSTANCE.getCreateUserId())")
    @Mapping(target = "datasetStatus", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Dataset datasetSaveDTO2Po(DatasetSaveDTO dto);

    // Dataset -> DatasetUpdateVO
    @Mapping(target = "datasetId", source = "id")
    DatasetEchoVO po2DatasetEchoVO(Dataset dataset);

    // Dataset -> DatasetDetailVO
    @Mapping(target = "datasetId", source = "id")
    @Mapping(target = "datasetType", expression = "java(BaseConvert.INSTANCE.getDictionaryValue(dataset.getDatasetType()))")
    @Mapping(target = "datasetStatus", qualifiedByName = "getDatasetStatus")
    @Mapping(target = "datasetUsage", qualifiedByName = "getDatasetUsage")
    @Mapping(target = "createUser", expression = "java(BaseConvert.INSTANCE.getCreateUser(dataset.getCreateBy()))")
    @Mapping(target = "entityNum", ignore = true)
    @Mapping(target = "classifyNum", ignore = true)
    @Mapping(target = "classifies", ignore = true)
    DatasetDetailVO po2DatasetDetailVO(Dataset dataset);

    // Dataset -> TrainingDatasetQueryVO
    @Mapping(target = "datasetId", source = "id")
    TrainingDatasetQueryVO po2TrainingDatasetQueryVO(Dataset dataset);

    // List<Dataset> datasetList -> List<TrainingDatasetQueryVO>
    List<TrainingDatasetQueryVO> po2TrainingDatasetQueryVOList(List<Dataset> datasetList);
}