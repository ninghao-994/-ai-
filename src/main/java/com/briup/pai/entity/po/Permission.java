package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("auth_permission")
@Schema(description = "权限PO")
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "父权限ID")
    @TableField(value = "parent_id")
    private Integer parentId;

    @Schema(description = "权限名称")
    @TableField(value = "name")
    private String name;

    @Schema(description = "权限类型（2按钮 1菜单 0目录）")
    @TableField(value = "type")
    private Integer type;

    @Schema(description = "路由路径")
    @TableField(value = "path")
    private String path;

    @Schema(description = "路由组件")
    @TableField(value = "component")
    private String component;

    @Schema(description = "按钮权限标识")
    @TableField(value = "perm")
    private String perm;

    @Schema(description = "是否隐藏（1隐藏 0显示）")
    @TableField(value = "hidden")
    private Integer hidden;

    @Schema(description = "面包屑名称")
    @TableField(value = "title")
    private String title;

    @Schema(description = "图标名称")
    @TableField(value = "icon")
    private String icon;

    @Schema(description = "排序字段")
    @TableField(value = "sort")
    private Integer sort;

    @Schema(description = "是否删除（1删除 0未删除）")
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;
}