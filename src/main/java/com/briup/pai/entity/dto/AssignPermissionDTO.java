package com.briup.pai.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分配权限DTO")
public class AssignPermissionDTO {

    @Schema(description = "角色编号")
    @NotNull(message = "角色ID不能为空")
    private Integer roleId;

    @Schema(description = "权限列表")
    @NotEmpty(message = "权限列表不能为空")
    private List<Integer> permissionIds;
}