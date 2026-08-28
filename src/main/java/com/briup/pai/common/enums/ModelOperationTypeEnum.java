package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 模型操作类型枚举
 */
@Getter
@AllArgsConstructor
public enum ModelOperationTypeEnum {

    INIT(1, "初始化训练"),
    OPTIMIZE(2, "优化训练"),
    EVALUATE(3, "评估训练");

    private final Integer type;
    private final String desc;
}
