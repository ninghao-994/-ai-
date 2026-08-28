package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求状态枚举
 */
@Getter
@AllArgsConstructor
public enum RequestStatusEnum {

    SUCCESS(1, "成功"),
    FAIL(2, "失败");

    private final Integer status;
    private final String desc;
}
