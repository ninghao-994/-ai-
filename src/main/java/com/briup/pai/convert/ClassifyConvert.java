package com.briup.pai.convert;

import com.briup.pai.entity.dto.ClassifySaveDTO;
import com.briup.pai.entity.po.Classify;
import com.briup.pai.entity.vo.ClassifyEchoVO;
import com.briup.pai.entity.vo.ClassifyInDatasetVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassifyConvert {

    // Classify -> ClassifyInDatasetVO
    @Mapping(target = "classifyId", source = "id")
    @Mapping(target = "entityNum", ignore = true)
    ClassifyInDatasetVO po2ClassifyInDatasetVO(Classify classify);

    // List<Classify> -> List<ClassifyInDatasetVO>
    List<ClassifyInDatasetVO> po2ClassifyInDatasetVOList(List<Classify> classifyList);

    // ClassifySaveDTO -> Classify
    @Mapping(target = "id", source = "classifyId")
    @Mapping(target = "isDeleted", ignore = true)
    Classify classifySaveDTO2Po(ClassifySaveDTO dto);

    // Classify -> ClassifySaveVO
    @Mapping(target = "classifyId", source = "id")
    ClassifyEchoVO po2ClassifyEchoVO(Classify classify);
}
