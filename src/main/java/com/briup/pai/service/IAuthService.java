package com.briup.pai.service;

import com.briup.pai.entity.dto.AssignPermissionDTO;
import com.briup.pai.entity.dto.AssignRoleDTO;
import com.briup.pai.entity.vo.AssignPermissionVO;
import com.briup.pai.entity.vo.AssignRoleVO;
import com.briup.pai.entity.vo.RouterVO;

import java.util.List;

public interface IAuthService {

    // 获取所有角色
    List<AssignRoleVO> getAllRoles();

    // 获取用户对应的角色编号
    List<Integer> getRoleIdsByUserId(Integer userId);

    // 分配角色
    void assignRole(AssignRoleDTO dto);

    // 获取所有权限
    List<AssignPermissionVO> getAllPermissions();

    // 获取角色对应的权限编号
    List<Integer> getPermissionIdsByRoleId(Integer roleId);

    // 分配权限
    void assignPermission(AssignPermissionDTO dto);

    // 查询登录用户路由
    List<RouterVO> getRouter(Integer userId);

    // 获取用户按钮权限列表
    List<String> getUserButtonPermissionList(Integer userId);
}
