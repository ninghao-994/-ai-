package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.RoleSaveDTO;
import com.briup.pai.service.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Tag(name = "角色控制器")
public class RoleController {

    @Resource
    private IRoleService roleService;

    @GetMapping
    @Operation(description = "获取角色列表")
    public Result getAllRoles() {
        return Result.success(roleService.getAllRoles());
    }

    @PostMapping
    @Operation(description = "新增角色")
    public Result addRole(
            @RequestBody
            @Validated(ValidatorGroups.insert.class) RoleSaveDTO roleSaveDTO) {
        return Result.success(roleService.addOrModifyRole(roleSaveDTO));
    }

    @GetMapping("/{roleId}")
    @Operation(description = "修改角色的数据回显")
    public Result getRoleById(
            @PathVariable(value = "roleId") Integer roleId) {
        return Result.success(roleService.getRoleById(roleId));
    }

    @PutMapping
    @Operation(description = "根据Id修改角色")
    public Result modifyRoleById(
            @RequestBody
            @Validated(ValidatorGroups.update.class) RoleSaveDTO roleSaveDTO) {
        return Result.success(roleService.addOrModifyRole(roleSaveDTO));
    }

    @DeleteMapping("/{roleId}")
    @Operation(description = "根据Id删除角色")
    public Result removeRoleById(@PathVariable(value = "roleId") Integer roleId) {
        roleService.removeRoleById(roleId);
        return Result.success();
    }
}