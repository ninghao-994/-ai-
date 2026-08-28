package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 权限枚举
 */
@Getter
@AllArgsConstructor
public enum PermissionTypeEnum {

    CATALOGUE(0, "目录"),
    MENU(1, "菜单"),
    BUTTON(2, "按钮");

    private final Integer type;
    private final String desc;
}
