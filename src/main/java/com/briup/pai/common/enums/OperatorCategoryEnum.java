package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 算子分类枚举
 */
@Getter
@AllArgsConstructor
public enum OperatorCategoryEnum {

    NETWORK_STRUCTURE(1, "网络结构"),
    OPTIMIZER(2, "优化器"),
    LOSS_VALUE(3, "损失函数");

    private final Integer category;
    private final String desc;

    public static List<Integer> categoryList() {
        return Arrays
                .stream(OperatorCategoryEnum.values())
                .map(OperatorCategoryEnum::getCategory)
                .toList();
    }
}
