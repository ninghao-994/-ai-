package com.briup.pai.convert;

import cn.hutool.core.util.ObjectUtil;
import com.briup.pai.common.enums.PermissionTypeEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.CustomException;
import com.briup.pai.entity.po.Permission;
import com.briup.pai.entity.vo.AssignPermissionVO;
import com.briup.pai.entity.vo.PermissionPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionConvert {

    // Permission -> PermissionPageVO
    @Mapping(target = "type", expression = "java(getPermissionType(permission.getType()))")
    @Mapping(target = "hidden", expression = "java(getPermissionHidden(permission.getHidden()))")
    @Mapping(target = "children", ignore = true)
    PermissionPageVO po2PermissionPageVO(Permission permission);

    // List<Permission> -> List<PermissionPageVO>
    List<PermissionPageVO> po2PermissionPageVOList(List<Permission> permissions);

    default String getPermissionType(Integer type) {
        if (type.equals(PermissionTypeEnum.CATALOGUE.getType())) {
            return PermissionTypeEnum.CATALOGUE.getDesc();
        } else if (type.equals(PermissionTypeEnum.MENU.getType())) {
            return PermissionTypeEnum.MENU.getDesc();
        } else if (type.equals(PermissionTypeEnum.BUTTON.getType())) {
            return PermissionTypeEnum.BUTTON.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    default Boolean getPermissionHidden(Integer hidden) {
        return ObjectUtil.equal(hidden, 1);
    }

    // Permission -> AssignPermissionVO
    @Mapping(target = "permissionId", source = "id")
    @Mapping(target = "permissionName", source = "name")
    @Mapping(target = "children", ignore = true)
    AssignPermissionVO po2AssignPermissionVO(Permission permission);

    // List<Permission> -> List<AssignPermissionVO>
    List<AssignPermissionVO> po2AssignPermissionVOList(List<Permission> list);
}
