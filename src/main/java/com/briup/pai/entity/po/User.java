package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("auth_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "用户名")
    @TableField(value = "username")
    private String username;

    @Schema(description = "密码")
    @TableField(value = "password")
    private String password;

    @Schema(description = "真实姓名")
    @TableField(value = "real_name")
    private String realName;

    @Schema(description = "手机号码")
    @TableField(value = "telephone")
    private String telephone;

    @Schema(description = "头像地址")
    @TableField(value = "header_url")
    private String headerUrl;

    @Schema(description = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @Schema(description = "用户状态（1禁用 0未禁用）")
    @TableField(value = "status")
    private Integer status;

    @Schema(description = "是否删除（1删除 0未删除）")
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;
}