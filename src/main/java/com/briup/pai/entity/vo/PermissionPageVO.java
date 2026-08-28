package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分页查询权限VO")
public class PermissionPageVO {

    @Schema(description = "权限ID")
    private Integer id;

    @Schema(description = "权限名称")
    private String name;

    @Schema(description = "权限类型")
    private String type;

    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "组件地址")
    private String component;

    @Schema(description = "按钮权限")
    private String perm;

    @Schema(description = "是否隐藏")
    private Boolean hidden;

    @Schema(description = "路由标题")
    private String title;

    @Schema(description = "路由图标")
    private String icon;

    @Schema(description = "子权限")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PermissionPageVO> children;
}
