package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据集用途枚举
 */
@Getter
@AllArgsConstructor
public enum DatasetUsageEnum {

    INIT(0, "初始化训练"),
    OPTIMIZE(1, "优化训练"),
    EVALUATE(2, "评估");

    private final Integer usage;
    private final String desc;
}