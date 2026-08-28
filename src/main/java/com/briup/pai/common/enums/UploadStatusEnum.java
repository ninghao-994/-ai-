package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 文件上传状态枚举
 */
@Getter
@AllArgsConstructor
public enum UploadStatusEnum {

    INIT(0, "初始化"),
    UPLOADING(1, "上传中"),
    PAUSED(2, "已暂停"),
    UPLOADED(3, "已上传");

    private final Integer status;
    private final String desc;

    public static List<Integer> statusList() {
        return Arrays.stream(UploadStatusEnum.values())
                .map(UploadStatusEnum::getStatus)
                .toList();
    }
}
