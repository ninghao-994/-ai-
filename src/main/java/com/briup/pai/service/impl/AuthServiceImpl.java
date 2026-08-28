package com.briup.pai.service.impl;

import com.briup.pai.entity.dto.AssignPermissionDTO;
import com.briup.pai.entity.dto.AssignRoleDTO;
import com.briup.pai.entity.vo.AssignPermissionVO;
import com.briup.pai.entity.vo.AssignRoleVO;
import com.briup.pai.entity.vo.RouterVO;
import com.briup.pai.service.IAuthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements IAuthService {

    @Override
    public List<AssignRoleVO> getAllRoles() {
        return List.of();
    }

    @Override
    public List<Integer> getRoleIdsByUserId(Integer userId) {
        return List.of();
    }

    @Override
    public void assignRole(AssignRoleDTO dto) {

    }

    @Override
    public List<AssignPermissionVO> getAllPermissions() {
        return List.of();
    }

    @Override
    public List<Integer> getPermissionIdsByRoleId(Integer roleId) {
        return List.of();
    }

    @Override
    public void assignPermission(AssignPermissionDTO dto) {

    }

    @Override
    public List<RouterVO> getRouter(Integer userId) {
        return List.of();
    }

    @Override
    public List<String> getUserButtonPermissionList(Integer userId) {
        return List.of();
    }
}