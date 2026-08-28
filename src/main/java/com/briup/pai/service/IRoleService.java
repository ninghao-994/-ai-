package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.RoleSaveDTO;
import com.briup.pai.entity.po.Role;
import com.briup.pai.entity.vo.RoleQueryVO;

import java.util.List;

public interface IRoleService extends IService<Role> {

    // 获取角色列表
    List<RoleQueryVO> getAllRoles();

    // 添加或修改角色
    RoleQueryVO addOrModifyRole(RoleSaveDTO roleSaveDTO);

    // 根据Id查询角色
    RoleQueryVO getRoleById(Integer roleId);

    // 根据Id删除角色
    void removeRoleById(Integer roleId);
}