package com.briup.pai.convert;

import com.briup.pai.entity.message.LabelResultMessage;
import com.briup.pai.entity.po.EvaluateLabel;
import com.briup.pai.entity.vo.ModelOperationResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvaluateLabelConvert {

    // LabelResultMessage -> EvaluateLabel
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evaluateId", ignore = true)
    EvaluateLabel labelResultMessage2Po(LabelResultMessage labelResultMessage);

    // Evaluate -> ModelOperationResultVO
    ModelOperationResultVO po2ModelOperationResultVO(EvaluateLabel evaluate);
}
