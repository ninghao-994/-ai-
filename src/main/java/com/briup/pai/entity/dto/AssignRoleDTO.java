package com.briup.pai.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分配角色DTO")
public class AssignRoleDTO {

    @Schema(description = "用户Id")
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @Schema(description = "角色列表")
    @NotEmpty(message = "角色列表不能为空")
    private List<Integer> roleIds;
}