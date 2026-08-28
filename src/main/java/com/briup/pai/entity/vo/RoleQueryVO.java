package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "角色查询VO")
public class RoleQueryVO {

    @Schema(description = "角色编号")
    private Integer roleId;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色描述")
    private String roleDesc;
}
