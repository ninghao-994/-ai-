package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "角色保存DTO")
public class RoleSaveDTO {

    @NotNull(message = "角色编号不能为空", groups = ValidatorGroups.update.class)
    @Null(message = "角色编号必须为空", groups = ValidatorGroups.insert.class)
    @Schema(description = "角色编号")
    private Integer roleId;

    @NotBlank(message = "角色名称不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色描述")
    private String roleDesc;
}