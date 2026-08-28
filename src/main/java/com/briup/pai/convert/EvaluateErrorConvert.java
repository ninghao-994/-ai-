package com.briup.pai.convert;

import com.briup.pai.entity.message.EvaluateErrorMessage;
import com.briup.pai.entity.po.EvaluateError;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvaluateErrorConvert {

    // EvaluateErrorMessage -> EvaluateError
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evaluateId", ignore = true)
    EvaluateError evaluateErrorMessage2Po(EvaluateErrorMessage evaluateErrorMessage);
}