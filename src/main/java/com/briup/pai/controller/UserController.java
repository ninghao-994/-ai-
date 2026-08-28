package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.UserSaveDTO;
import com.briup.pai.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@Tag(name = "用户控制器")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/{pageNum}/{pageSize}")
    @Operation(summary = "条件分页查询所有用户")
    public Result getUserByPageAndCondition(
            @PathVariable(value = "pageNum") Long pageNum,
            @PathVariable(value = "pageSize") Long pageSize,
            @RequestParam(value = "keyword", required = false) String keyword) {
        return Result.success(userService.getUserByPageAndCondition(pageNum, pageSize, keyword));
    }

    @PostMapping
    @Operation(summary = "新增用户")
    public Result addUser(
            @RequestBody
            @Validated(ValidatorGroups.insert.class) UserSaveDTO dto) {
        return Result.success(userService.addOrModifyUser(dto));
    }

    @PostMapping("/upload")
    @Operation(summary = "用户上传头像")
    public Result uploadProfilePicture(
            @RequestParam("file") MultipartFile file) {
        return Result.success(userService.uploadProfilePicture(file));
    }

    @GetMapping("/{userId}")
    @Operation(summary = "修改用户的数据回显")
    public Result queryUserById(@PathVariable(value = "userId") Integer userId) {
        return Result.success(userService.getUserById(userId));
    }

    @PutMapping
    @Operation(summary = "修改用户")
    public Result modifyUser(
            @RequestBody
            @Validated(ValidatorGroups.update.class) UserSaveDTO dto) {
        return Result.success(userService.addOrModifyUser(dto));
    }

    @PutMapping("/{userId}")
    @Operation(summary = "重置密码")
    public Result resetPassword(@PathVariable(value = "userId") Integer userId) {
        userService.resetPassword(userId);
        return Result.success();
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "根据Id删除用户")
    public Result removeUserById(@PathVariable(value = "userId") Integer userId) {
        userService.removeUserById(userId);
        return Result.success();
    }

    @PutMapping("/{userId}/{status}")
    @Operation(summary = "禁用或者启用用户账号")
    public Result disableOrEnableUser(
            @PathVariable(value = "userId") Integer userId,
            @PathVariable(value = "status") Integer status) {
        userService.disableOrEnableUser(userId, status);
        return Result.success();
    }
}