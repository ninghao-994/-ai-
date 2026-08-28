package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.PermissionMapper;
import com.briup.pai.entity.po.Permission;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.entity.vo.PermissionPageVO;
import com.briup.pai.service.IPermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public PageVO<PermissionPageVO> getPermissionByPage(Long pageNum, Long pageSize) {
        return null;
    }
}