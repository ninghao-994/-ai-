package com.briup.pai.convert;

import cn.hutool.core.util.ObjectUtil;
import com.briup.pai.common.enums.OperatorCategoryEnum;
import com.briup.pai.common.enums.OperatorTypeEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.CustomException;
import com.briup.pai.entity.dto.OperatorImportDTO;
import com.briup.pai.entity.dto.OperatorUpdateDTO;
import com.briup.pai.entity.po.Operator;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.OperatorEchoVO;
import com.briup.pai.entity.vo.OperatorPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperatorConvert {

    // Operator -> OperatorPageVO
    @Mapping(target = "operatorId", source = "id")
    @Mapping(target = "createUser", expression = "java(BaseConvert.INSTANCE.getCreateUser(operator.getCreateBy()))")
    @Mapping(target = "operatorType", qualifiedByName = "getOperatorTypeStr")
    @Mapping(target = "operatorCategory", qualifiedByName = "getOperatorCategoryStr")
    OperatorPageVO po2OperatorPageVO(Operator operator);

    // List<Operator> -> List<OperatorPageVO>
    List<OperatorPageVO> po2OperatorPageVOList(List<Operator> operators);

    @Named("getOperatorTypeStr")
    default String getOperatorTypeStr(Integer operatorType) {
        if (ObjectUtil.equal(operatorType, OperatorTypeEnum.BASE.getType())) {
            return OperatorTypeEnum.BASE.getDesc();
        } else if (ObjectUtil.equal(operatorType, OperatorTypeEnum.CUSTOMIZE.getType())) {
            return OperatorTypeEnum.CUSTOMIZE.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    @Named("getOperatorCategoryStr")
    default String getOperatorCategoryStr(Integer operatorCategory) {
        if (ObjectUtil.equal(operatorCategory, OperatorCategoryEnum.NETWORK_STRUCTURE.getCategory())) {
            return OperatorCategoryEnum.NETWORK_STRUCTURE.getDesc();
        } else if (ObjectUtil.equal(operatorCategory, OperatorCategoryEnum.OPTIMIZER.getCategory())) {
            return OperatorCategoryEnum.OPTIMIZER.getDesc();
        } else if (ObjectUtil.equal(operatorCategory, OperatorCategoryEnum.LOSS_VALUE.getCategory())) {
            return OperatorCategoryEnum.LOSS_VALUE.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    // Operator -> OperatorEchoVO
    @Mapping(target = "operatorId", source = "id")
    OperatorEchoVO po2OperatorEchoVO(Operator operator);

    // OperatorUpdateDTO -> Operator
    @Mapping(target = "id", source = "operatorId")
    @Mapping(target = "operatorType", ignore = true)
    @Mapping(target = "operatorCategory", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    Operator operatorUpdateDTO2po(OperatorUpdateDTO dto);

    // OperatorImportDTO -> Operator
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "operatorType", source = "operatorType", qualifiedByName = "getOperatorTypeNum")
    @Mapping(target = "operatorCategory", source = "operatorCategory", qualifiedByName = "getOperatorCategoryNum")
    @Mapping(target = "createBy", expression = "java(BaseConvert.INSTANCE.getCreateUserId())")
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Operator operatorImportDto2Po(OperatorImportDTO dto);

    // List<OperatorImportDTO> -> List<Operator>
    List<Operator> operatorImportDto2PoList(List<OperatorImportDTO> operatorExcelDTOList);

    @Named("getOperatorTypeNum")
    default Integer getOperatorTypeNum(String operatorType) {
        if (ObjectUtil.equal(operatorType, OperatorTypeEnum.BASE.getDesc())) {
            return OperatorTypeEnum.BASE.getType();
        } else if (ObjectUtil.equal(operatorType, OperatorTypeEnum.CUSTOMIZE.getDesc())) {
            return OperatorTypeEnum.CUSTOMIZE.getType();
        } else {
            return -1;
        }
    }

    @Named("getOperatorCategoryNum")
    default Integer getOperatorCategoryNum(String operatorCategory) {
        if (ObjectUtil.equal(operatorCategory, OperatorCategoryEnum.NETWORK_STRUCTURE.getDesc())) {
            return OperatorCategoryEnum.NETWORK_STRUCTURE.getCategory();
        } else if (ObjectUtil.equal(operatorCategory, OperatorCategoryEnum.OPTIMIZER.getDesc())) {
            return OperatorCategoryEnum.OPTIMIZER.getCategory();
        } else if (ObjectUtil.equal(operatorCategory, OperatorCategoryEnum.LOSS_VALUE.getDesc())) {
            return OperatorCategoryEnum.LOSS_VALUE.getCategory();
        } else {
            return -1;
        }
    }

    // Operator -> DropDownVO
    @Mapping(target = "key", source = "operatorUrl")
    @Mapping(target = "value", source = "operatorName")
    DropDownVO po2DropDownVO(Operator operator);

    // List<Operator> -> List<DropDownVO>
    List<DropDownVO> po2DropDownList(List<Operator> operators);
}