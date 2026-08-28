package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "当前登录用户VO")
public class CurrentLoginUserVO {

    @Schema(description = "用户Id")
    private Integer userId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "头像地址")
    private String headerUrl;

    @Schema(description = "用户路由菜单")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RouterVO> menu;

    @Schema(description = "用户按钮权限")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> buttons;
}