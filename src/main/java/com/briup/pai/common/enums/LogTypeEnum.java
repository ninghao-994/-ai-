package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日志类型枚举
 */
@Getter
@AllArgsConstructor
public enum LogTypeEnum {

    OPERATION(1, "操作日志"),
    LOGIN(2, "登录日志");

    private final Integer type;
    private final String desc;
}
