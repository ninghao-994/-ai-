package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "用户保存")
public class UserSaveDTO {

    @NotNull(message = "用户编号不能为空", groups = {ValidatorGroups.update.class})
    @Null(message = "用户编号必须为空", groups = {ValidatorGroups.insert.class})
    @Schema(description = "用户编号")
    private Integer userId;

    @NotBlank(message = "用户名不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "真实姓名")
    private String realName;

    @Schema(description = "用户头像")
    private String headerUrl;

    @Schema(description = "手机号码")
    private String telephone;
}