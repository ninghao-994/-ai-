package com.briup.pai.convert;

import com.briup.pai.entity.dto.ModelOperationDTO;
import com.briup.pai.entity.po.ModelConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelConfigConvert {

    // ModelOperationDTO -> ModelConfig
    @Mapping(target = "id", ignore = true)
    ModelConfig modelOperationDTO2Po(ModelOperationDTO modelOperationDTO);
}
