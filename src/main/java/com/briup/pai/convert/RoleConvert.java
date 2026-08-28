package com.briup.pai.convert;

import com.briup.pai.entity.dto.RoleSaveDTO;
import com.briup.pai.entity.po.Role;
import com.briup.pai.entity.vo.AssignRoleVO;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.RoleQueryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleConvert {

    // Role -> DropDownVO
    @Mapping(target = "key", source = "id")
    @Mapping(target = "value", source = "roleName")
    DropDownVO po2DropDownVO(Role role);

    // List<Role> -> List<DropDownVO>
    List<DropDownVO> po2DropDownVOList(List<Role> roles);

    // Role -> RoleQueryVO
    @Mapping(target = "roleId", source = "id")
    RoleQueryVO po2RoleQueryVO(Role role);

    // List<Role> -> List<RoleQueryVO>
    List<RoleQueryVO> po2RoleQueryVOList(List<Role> roles);

    // RoleSaveDTO -> Role
    @Mapping(target = "id", source = "roleId")
    @Mapping(target = "isDeleted", ignore = true)
    Role roleSaveDTO2Po(RoleSaveDTO roleSaveDTO);

    // Role -> AssignRoleVO
    @Mapping(target = "roleId", source = "id")
    AssignRoleVO po2AssignRoleVO(Role role);

    // List<Role> -> List<AssignRoleVO>
    List<AssignRoleVO> po2AssignRoleVOList(List<Role> list);
}
