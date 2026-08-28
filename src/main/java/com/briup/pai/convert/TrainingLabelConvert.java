package com.briup.pai.convert;

import com.briup.pai.entity.message.LabelResultMessage;
import com.briup.pai.entity.po.TrainingLabel;
import com.briup.pai.entity.vo.ModelOperationResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingLabelConvert {

    // LabelResultMessage -> TrainingLabel
    @Mapping(target = "trainingId", ignore = true)
    @Mapping(target = "id", ignore = true)
    TrainingLabel labelResultMessage2Po(LabelResultMessage labelResultMessage);

    // TrainingLabel -> ModelOperationResultVO
    ModelOperationResultVO po2ModelOperationResultVO(TrainingLabel trainingLabel);
}