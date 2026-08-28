package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.RoleMapper;
import com.briup.pai.entity.dto.RoleSaveDTO;
import com.briup.pai.entity.po.Role;
import com.briup.pai.entity.vo.RoleQueryVO;
import com.briup.pai.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<RoleQueryVO> getAllRoles() {
        return List.of();
    }

    @Override
    public RoleQueryVO addOrModifyRole(RoleSaveDTO roleSaveDTO) {
        return null;
    }

    @Override
    public RoleQueryVO getRoleById(Integer roleId) {
        return null;
    }

    @Override
    public void removeRoleById(Integer roleId) {

    }
}