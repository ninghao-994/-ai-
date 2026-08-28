package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("auth_user_role")
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "用户ID")
    @TableField(value = "user_id")
    private Integer userId;

    @Schema(description = "角色ID")
    @TableField(value = "role_id")
    private Integer roleId;

    @Schema(description = "是否删除（1删除 0未删除）")
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;
}