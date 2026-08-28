package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "用户分页VO")
public class UserPageVO {

    @Schema(description = "用户编号")
    private Integer userId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "真实姓名")
    private String realName;

    @Schema(description = "手机号码")
    private String telephone;

    @Schema(description = "头像地址")
    private String headerUrl;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "是否禁用")
    private Integer status;
}
