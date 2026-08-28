package com.briup.pai.common.result;

import com.briup.pai.common.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;
    // 响应携带的数据
    private Object data;

    private void setResultCode(ResultCodeEnum resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * 操作成功，没有返回数据
     *
     * @return Result对象
     */
    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        return result;
    }

    /**
     * 操作成功，有返回数据
     *
     * @param data 数据
     * @return     Result对象
     */
    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    /**
     * 操作失败，返回默认状态码
     *
     * @return Result对象
     */
    public static Result failure() {
        Result failure = new Result();
        failure.setResultCode(ResultCodeEnum.ERROR);
        return failure;
    }

    /**
     * 操作失败，没有返回的数据
     *
     * @param resultCode 统一状态码
     * @return           Result对象
     */
    public static Result failure(ResultCodeEnum resultCode) {
        Result failure = failure();
        failure.setResultCode(resultCode);
        return failure;
    }

    public static Result failure(Integer code, String message) {
        Result failure = new Result();
        failure.setCode(code);
        failure.setMessage(message);
        return failure;
    }
}