package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 用户账号状态枚举
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {

    AVAILABLE(0, "可用"),
    DISABLE(1, "禁用");

    private final Integer status;
    private final String desc;

    public static List<Integer> statusList() {
        return Arrays.stream(UserStatusEnum.values())
                .map(UserStatusEnum::getStatus)
                .toList();
    }
}
