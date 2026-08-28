package com.briup.pai.convert;

import com.briup.pai.common.enums.ModelStatusEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.enums.TrainingStatusEnum;
import com.briup.pai.common.exception.CustomException;
import com.briup.pai.entity.dto.ModelOperationDTO;
import com.briup.pai.entity.dto.ModelSaveDTO;
import com.briup.pai.entity.message.ModelInitTrainMessage;
import com.briup.pai.entity.message.ModelOptimizeTrainMessage;
import com.briup.pai.entity.po.Model;
import com.briup.pai.entity.vo.ModelDetailVO;
import com.briup.pai.entity.vo.ModelEchoVO;
import com.briup.pai.entity.vo.ModelPageVO;
import com.briup.pai.entity.vo.ReleaseModelVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelConvert {

    // Model -> ModelPageVO
    @Mapping(target = "modelId", source = "id")
    @Mapping(target = "modelStatus", qualifiedByName = "getModelStatus")
    @Mapping(target = "modelType", expression = "java(BaseConvert.INSTANCE.getDictionaryValue(model.getModelType()))")
    @Mapping(target = "trainingStatus", qualifiedByName = "getTrainingStatus")
    ModelPageVO po2ModelPageVO(Model model);

    // List<Model> -> List<ModelPageVO>
    List<ModelPageVO> po2ModelPageVOList(List<Model> records);

    // Model -> ModelEchoVO
    @Mapping(target = "modelId", source = "id")
    ModelEchoVO po2ModelEchoVO(Model model);

    // ModelSaveDTO -> Model
    @Mapping(target = "id", source = "modelId")
    @Mapping(target = "modelStatus", ignore = true)
    @Mapping(target = "lastModelVersion", ignore = true)
    @Mapping(target = "trainingStatus", ignore = true)
    @Mapping(target = "accuracyRate", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Model modelSaveDTO2Po(ModelSaveDTO modelSaveDTO);

    // ModelOperationDTO -> ModelInitTrainMessage
    @Mapping(target = "modelVersion", ignore = true)
    @Mapping(target = "trainingId", ignore = true)
    @Mapping(target = "data", ignore = true)
    ModelInitTrainMessage modelOperationDTO2InitMessage(ModelOperationDTO modelOperationDTO);

    // ModelOperationDTO -> ModelOptimizeTrainMessage
    @Mapping(target = "modelVersion", ignore = true)
    @Mapping(target = "trainingId", ignore = true)
    @Mapping(target = "data", ignore = true)
    @Mapping(target = "oldModelPath", ignore = true)
    ModelOptimizeTrainMessage modelOperationDTO2OptimizeMessage(ModelOperationDTO modelOperationDTO);

    // Model -> ModelDetailVO
    @Mapping(target = "modelId", source = "id")
    @Mapping(target = "modelStatus", qualifiedByName = "getModelStatus")
    @Mapping(target = "modelType", expression = "java(BaseConvert.INSTANCE.getDictionaryValue(model.getModelType()))")
    @Mapping(target = "trainingStatus", qualifiedByName = "getTrainingStatus")
    @Mapping(target = "trainingHistory", ignore = true)
    ModelDetailVO po2ModelDetailVO(Model model);

    @Named("getModelStatus")
    default String getModelStatus(Integer status) {
        if (status.equals(ModelStatusEnum.Unpublished.getStatus())) {
            return ModelStatusEnum.Unpublished.getDesc();
        } else if (status.equals(ModelStatusEnum.Published.getStatus())) {
            return ModelStatusEnum.Published.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    @Named("getTrainingStatus")
    default String getTrainingStatus(Integer status) {
        if (status.equals(TrainingStatusEnum.NO_TRAINING.getStatus())) {
            return TrainingStatusEnum.NO_TRAINING.getDesc();
        } else if (status.equals(TrainingStatusEnum.TRAINING.getStatus())) {
            return TrainingStatusEnum.TRAINING.getDesc();
        } else if (status.equals(TrainingStatusEnum.OPTIMIZING.getStatus())) {
            return TrainingStatusEnum.OPTIMIZING.getDesc();
        } else if (status.equals(TrainingStatusEnum.EVALUATING.getStatus())) {
            return TrainingStatusEnum.EVALUATING.getDesc();
        } else if (status.equals(TrainingStatusEnum.DONE.getStatus())) {
            return TrainingStatusEnum.DONE.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    // Model -> ReleaseModelVO
    @Mapping(target = "modelId", source = "id")
    ReleaseModelVO po2ReleaseModelVO(Model model);
}