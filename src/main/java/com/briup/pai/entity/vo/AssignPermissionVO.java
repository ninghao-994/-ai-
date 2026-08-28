package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分配权限VO")
public class AssignPermissionVO {
    
    @Schema(description = "权限Id")
    private Integer permissionId;
    
    @Schema(description = "权限名称")
    private String permissionName;

    @Schema(description = "子权限")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AssignPermissionVO> children;
}