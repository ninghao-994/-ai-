package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.entity.dto.AssignPermissionDTO;
import com.briup.pai.entity.dto.AssignRoleDTO;
import com.briup.pai.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "授权控制器")
public class AuthController {

    @Resource
    private IAuthService authService;

    @GetMapping("/roles")
    @Operation(summary = "查询所有角色")
    public Result getAllRoles() {
        return Result.success(authService.getAllRoles());
    }

    @GetMapping("/role/{userId}")
    @Operation(summary = "根据用户Id查询用户的角色Id集合")
    public Result getRoleIdsByUserId(
            @PathVariable("userId") Integer userId) {
        return Result.success(authService.getRoleIdsByUserId(userId));
    }

    @PostMapping("/assign/role")
    @Operation(summary = "分配角色")
    public Result assignRole(
            @RequestBody
            @Valid AssignRoleDTO dto) {
        authService.assignRole(dto);
        return Result.success();
    }

    @GetMapping("/permissions")
    @Operation(summary = "查询所有权限")
    public Result getPermissionList() {
        return Result.success(authService.getAllPermissions());
    }

    @GetMapping("/permission/{roleId}")
    @Operation(summary = "根据角色Id查询角色的权限Id集合")
    public Result getPermissionIdsByRoleId(
            @PathVariable("roleId") Integer roleId) {
        return Result.success(authService.getPermissionIdsByRoleId(roleId));
    }

    @PostMapping("/assign/permission")
    @Operation(summary = "分配权限")
    public Result assignPermission(
            @RequestBody
            @Valid AssignPermissionDTO dto) {
        authService.assignPermission(dto);
        return Result.success();
    }
}