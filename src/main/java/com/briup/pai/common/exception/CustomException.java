package com.briup.pai.common.exception;

import com.briup.pai.common.enums.ResultCodeEnum;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ResultCodeEnum resultCodeEnum;

    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.resultCodeEnum = resultCodeEnum;
    }
}