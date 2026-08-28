package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "修改用户数据回显VO")
public class UserEchoVO {

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
}
