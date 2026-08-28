package com.briup.pai.common.exception;

import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.result.Result;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // 获取绑定的结果
        BindingResult bindingResult = ex.getBindingResult();
        // 获取校验出现的错误
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        // 拼接错误信息
        String errorMsg = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(";"));
        log.error("发生MethodArgumentNotValidException类型异常，异常信息：{}", errorMsg);
        return Result.failure(ResultCodeEnum.PARAM_VERIFY_ERROR.getCode(), errorMsg);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        // 获取异常信息，格式如下：方法名.参数名：异常信息，……
        String message = ex.getMessage();
        // 处理异常信息
        String errorMsg = Arrays.stream(message.split(",")).map(msg -> msg.substring(msg.lastIndexOf(" ") + 1))
                .collect(Collectors.joining(";"));
        log.error("发生ConstraintViolationException类型异常，异常信息：{}", errorMsg);
        return Result.failure(ResultCodeEnum.PARAM_VERIFY_ERROR.getCode(), errorMsg);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        Throwable cause = e.getCause();
        CustomException customException = null;

        if (cause instanceof CustomException) {
            customException = (CustomException) cause;
        } else if (e instanceof CustomException) {
            customException = (CustomException) e;
        }

        if (customException != null) {
            log.error("发生CustomException类型异常，异常信息：{}", customException.getResultCodeEnum().getMessage());
            return Result.failure(customException.getResultCodeEnum());
        } else {
            log.error("发生Exception类型异常，异常信息：{}", e.getMessage());
            return Result.failure(ResultCodeEnum.ERROR);
        }
    }
}