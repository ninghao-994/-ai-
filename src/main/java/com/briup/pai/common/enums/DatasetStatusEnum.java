package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 数据集状态枚举
 */
@Getter
@AllArgsConstructor
public enum DatasetStatusEnum {

    INIT(0, "初始化"),
    UPLOADING(1, "上传中"),
    DONE(2, "已上传");

    private final Integer status;
    private final String desc;

    public static List<Integer> statusList() {
        return Arrays.stream(DatasetStatusEnum.values())
                .map(DatasetStatusEnum::getStatus)
                .toList();
    }
}
