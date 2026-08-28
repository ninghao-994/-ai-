package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.service.IPermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
@Tag(name = "权限控制器")
public class PermissionController {

    @Resource
    private IPermissionService permissionService;

    @GetMapping("/{pageNum}/{pageSize}")
    @Operation(summary = "分页查询权限信息")
    public Result getPermissionByPage(
            @PathVariable(value = "pageNum") Long pageNum,
            @PathVariable(value = "pageSize") Long pageSize) {
        return Result.success(permissionService.getPermissionByPage(pageNum, pageSize));
    }
}