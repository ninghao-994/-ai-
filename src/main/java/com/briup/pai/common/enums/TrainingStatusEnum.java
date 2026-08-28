package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 模型训练状态枚举
 */
@Getter
@AllArgsConstructor
public enum TrainingStatusEnum {

    NO_TRAINING(0, "未训练"),
    TRAINING(1, "训练中"),
    OPTIMIZING(2, "优化中"),
    EVALUATING(3, "评估中"),
    DONE(4, "完成"),
    ERROR(5, "失败");

    private final Integer status;
    private final String desc;
}
