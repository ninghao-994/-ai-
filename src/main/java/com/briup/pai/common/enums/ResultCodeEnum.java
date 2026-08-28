package com.briup.pai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求状态码枚举
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    /* 成功状态码（默认） */
    SUCCESS(200, "success"),

    /* 失败状态码（默认） */
    ERROR(500, "服务器内部错误"),

    /* 通用错误 10001 - 19999 */
    PARAM_VERIFY_ERROR(10001, "参数校验失败"),
    PARAM_IS_ERROR(10002, "参数有误"),
    DATA_ALREADY_EXIST(10003, "数据已经存在"),
    DATA_NOT_EXIST(10004, "数据不存在，刷新页面重试"),
    DATA_CAN_NOT_DELETE(10005, "数据不能删除"),
    HAS_NO_PERMISSION(10006, "没有权限"),

    /* 文件相关错误 20001 - 29999 */
    FILE_IS_EMPTY(20001, "文件为空"),
    FILE_NAME_IS_EMPTY(20002, "文件名为空"),
    FILE_TYPE_ERROR(20003, "文件类型不符合要求"),
    FILE_IMPORT_ERROR(20004, "文件导入失败"),
    FILE_UPLOAD_ERROR(20005, "文件上传失败"),
    FILE_IS_NOT_UPLOADED(20006, "文件未上传完毕"),
    FILE_MERGE_ERROR(20007, "文件合并失败"),
    FILE_EXPORT_ERROR(20008, "文件导出失败"),

    /* 登录相关错误 30001 - 39999 */
    USER_NOT_EXIST(30001, "用户不存在"),
    PASSWORD_IS_WRONG(30002, "密码错误"),
    USER_IS_DISABLED(30003, "用户已禁用"),
    USER_NOT_LOGIN(30004, "用户未登录"),
    USER_LOGIN_EXPIRATION(30005, "用户登录过期"),
    MESSAGE_SEND_ERROR(30006, "验证码发送失败"),
    USER_VERIFY_CODE_ALREADY_EXIST(30007, "验证码存在，请勿重复发送"),
    USER_VERIFY_CODE_NOT_EXIST(30008, "验证码不存在"),
    USER_VERIFY_CODE_ERROR(30009, "验证码错误"),

    /* 业务相关错误 40001 - 49999 */
    DATASET_STATUS_ERROR(40001, "数据集状态错误，刷新页面重试"),
    MODEL_CAN_NOT_EVALUATE(40002, "该数据集已经评估过该版本"),
    MODEL_CAN_NOT_RELEASE(40003, "模型准确率低于阈值，无法删除"),
    DISABLE_OR_ENABLE_ERROR(40004, "无法禁用自己的账号"),
    ASSIGN_ROLE_ERROR(40005, "无法为自己的账号授权"),

    ;
    private final Integer code;
    private final String message;
}