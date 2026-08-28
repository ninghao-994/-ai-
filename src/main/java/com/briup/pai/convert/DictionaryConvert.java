package com.briup.pai.convert;

import com.briup.pai.entity.dto.DictionarySaveDTO;
import com.briup.pai.entity.po.Dictionary;
import com.briup.pai.entity.vo.DictionaryEchoVO;
import com.briup.pai.entity.vo.DictionaryPageVO;
import com.briup.pai.entity.vo.DropDownVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DictionaryConvert {

    // DictionarySaveDTO -> Dictionary
    @Mapping(target = "id", source = "dictId")
    @Mapping(target = "isDeleted", ignore = true)
    Dictionary dictionarySaveDTO2PO(DictionarySaveDTO dto);

    // Dictionary -> DictionaryEchoVO
    @Mapping(target = "dictId", source = "id")
    DictionaryEchoVO po2DictionaryEchoVO(Dictionary dictionary);

    // Dictionary -> DictionaryQueryByPageVO
    @Mapping(target = "dictId", source = "id")
    @Mapping(target = "children", ignore = true)
    DictionaryPageVO po2DictionaryPageVO(Dictionary dictionary);

    // List<Dictionary> -> List<DictionaryPageVO>
    List<DictionaryPageVO> po2DictionaryPageVOList(List<Dictionary> dictList);

    // Dictionary -> DictionaryDropDownVO
    @Mapping(target = "key", source = "id")
    @Mapping(target = "value", source = "dictValue")
    DropDownVO po2DictionaryDropDownVO(Dictionary dictionary);

    // List<Dictionary> -> List<DropDownVO>
    List<DropDownVO> po2DictionaryDropDownVOList(List<Dictionary> dictList);
}