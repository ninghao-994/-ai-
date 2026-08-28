package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ModelStatusEnum {

    Unpublished(0, "未发布"),
    Published(1, "已发布"),
    ;

    private final Integer status;
    private final String desc;
}
