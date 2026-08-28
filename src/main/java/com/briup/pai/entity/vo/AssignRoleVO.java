package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分配角色VO")
public class AssignRoleVO {

    @Schema(description = "角色编号")
    private Integer roleId;

    @Schema(description = "角色名称")
    private String roleName;
}
