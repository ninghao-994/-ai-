package com.briup.pai.entity.dto;

import com.briup.pai.common.constant.LoginConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "手机号登录DTO")
public class LoginWithPhoneDTO {

    @Schema(description = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = LoginConstant.USER_TELEPHONE_REGEX, message = "手机号码格式不对")
    private String telephone;

    @Schema(description = "验证码")
    @NotNull(message = "验证码不能为空")
    private Integer code;
}