package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.po.Permission;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.entity.vo.PermissionPageVO;

public interface IPermissionService extends IService<Permission> {

    // 分页查询权限信息
    PageVO<PermissionPageVO> getPermissionByPage(Long pageNum, Long pageSize);
}