package com.briup.pai.controller;

import com.briup.pai.common.constant.LoginConstant;
import com.briup.pai.common.result.Result;
import com.briup.pai.entity.dto.LoginWithPhoneDTO;
import com.briup.pai.entity.dto.LoginWithUsernameDTO;
import com.briup.pai.service.ILoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Tag(name = "登录控制器")
public class LoginController {

    @Resource
    private ILoginService loginService;

    @PostMapping("/withUsername")
    @Operation(summary = "用户名密码登录")
    public Result loginWithUsername(
            @RequestBody
            @Valid LoginWithUsernameDTO dto) {
        return Result.success(loginService.loginWithUsername(dto));
    }

    @GetMapping("/getCurrentUser")
    @Operation(summary = "获取当前登录的用户信息")
    public Result getCurrentUser() {
        return Result.success(loginService.getCurrentUser());
    }

    @PostMapping("/sendMessageCode")
    @Operation(summary = "发送短信验证码")
    public Result sendMessageCode(
            @RequestParam(value = "telephone")
            @Pattern(
                    regexp = LoginConstant.USER_TELEPHONE_REGEX,
                    message = "手机号码格式有误") String telephone) {
        loginService.sendMessageCode(telephone);
        return Result.success();
    }

    @PostMapping("/withTelephone")
    @Operation(summary = "手机号验证码登录")
    public Result loginWithPhone(
            @RequestBody
            @Valid LoginWithPhoneDTO dto) {
        return Result.success(loginService.loginWithTelephone(dto));
    }

    @PostMapping("/logout")
    @Operation(summary = "退出登录")
    public Result logout() {
        return Result.success();
    }
}