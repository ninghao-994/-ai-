package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 算子类型枚举
 */
@Getter
@AllArgsConstructor
public enum OperatorTypeEnum {

    BASE(0, "基础算子"),
    CUSTOMIZE(1, "自定义算子");

    private final Integer type;
    private final String desc;
}
