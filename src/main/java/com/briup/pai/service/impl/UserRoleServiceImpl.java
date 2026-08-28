package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.UserRoleMapper;
import com.briup.pai.entity.po.UserRole;
import com.briup.pai.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}