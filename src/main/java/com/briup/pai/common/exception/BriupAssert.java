package com.briup.pai.common.exception;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.common.enums.ResultCodeEnum;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BriupAssert {

    /**
     * 抛出异常
     * @param resultCodeEnum 自定义状态码
     */
    public static void throwException(ResultCodeEnum resultCodeEnum) {
        throw new CustomException(resultCodeEnum);
    }

    /**
     * 要求参数为true
     * @param b                 参数
     * @param resultCodeEnum    自定义状态码
     */
    public static void requireTrue(Boolean b, ResultCodeEnum resultCodeEnum) {
        if (!b) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求参数为false
     * @param b                 参数
     * @param resultCodeEnum    自定义状态码
     */
    public static void requireFalse(Boolean b, ResultCodeEnum resultCodeEnum) {
        if (b) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求对象不为空
     * @param obj            对象
     * @param resultCodeEnum 自定义状态码
     */
    public static Object requireNotNull(Object obj, ResultCodeEnum resultCodeEnum) {
        if (ObjectUtil.isEmpty(obj)) {
            throw new CustomException(resultCodeEnum);
        }
        return obj;
    }

    /**
     * 要求对象为空
     * @param obj            对象
     * @param resultCodeEnum 自定义状态码
     */
    public static void requireNull(Object obj, ResultCodeEnum resultCodeEnum) {
        if (ObjectUtil.isNotEmpty(obj)) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求两个对象相同
     * @param o1             对象1
     * @param o2             对象2
     * @param resultCodeEnum 自定义状态码
     */
    public static void requireEqual(Object o1, Object o2, ResultCodeEnum resultCodeEnum) {
        if (ObjectUtil.notEqual(o1, o2)) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求两个对象不相同
     * @param o1                对象1
     * @param o2                对象2
     * @param resultCodeEnum    自定义状态码
     */
    public static void requireNotEqual(Object o1, Object o2, ResultCodeEnum resultCodeEnum) {
        if (ObjectUtil.equal(o1, o2)) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求对象在集合中
     * @param o1             对象
     * @param o2             集合
     * @param resultCodeEnum 自定义状态码
     */
    public static <T> void requireIn(T o1, List<T> o2, ResultCodeEnum resultCodeEnum) {
        if (!o2.contains(o1)) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求对象不在集合中
     * @param o1             对象
     * @param o2             集合
     * @param resultCodeEnum 自定义状态码
     */
    public static <T> void requireNotIn(T o1, List<T> o2, ResultCodeEnum resultCodeEnum) {
        if (o2.contains(o1)) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求数据不存在的校验
     * @param service        业务层对象
     * @param function       查询条件
     * @param value          查询条件值
     * @param functionId     ID查询条件
     * @param IdField        ID值
     * @param resultCodeEnum 自定义错误码
     * @param <T>            数据类型
     */
    public static <T> void requireNull(IService<T> service,
                                       SFunction<T, ?> function,
                                       Object value,
                                       SFunction<T, Object> functionId,
                                       Object IdField,
                                       ResultCodeEnum resultCodeEnum) {
        LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(function, value);
        T t = service.getOne(wrapper);
        if (t != null && !functionId.apply(t).equals(IdField)) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求数据不存在的校验
     * @param service        业务层对象
     * @param function       查询条件
     * @param value          查询条件值
     * @param resultCodeEnum 自定义状态码
     * @param <T>            数据类型
     */
    public static <T> void requireNull(IService<T> service,
                                       SFunction<T, ?> function,
                                       Object value,
                                       ResultCodeEnum resultCodeEnum) {
        // 创建查询条件构造器
        LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(function, value);
        if (service.count(wrapper) > 0L) {
            throw new CustomException(resultCodeEnum);
        }
    }

    /**
     * 要求数据存在校验
     * @param service           业务层对象
     * @param function          查询条件
     * @param value             查询条件值
     * @param resultCodeEnum    自定义状态码
     * @return                  查询的对象
     * @param <T>               数据类型
     */
    public static <T> T requireNotNull(IService<T> service,
                                       SFunction<T, ?> function,
                                       Object value,
                                       ResultCodeEnum resultCodeEnum) {
        // 创建查询条件构造器
        LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(function, value);
        T t = service.getOne(wrapper);
        if (ObjectUtil.isEmpty(t)) {
            throw new CustomException(resultCodeEnum);
        }
        return t;
    }


    public static void requirePic(MultipartFile file) {
        List<String> fileTypes = List.of("png", "jpg", "jpeg", "gif");
        validatorFile(file, fileTypes);
    }

    public static void requireExcel(MultipartFile file) {
        List<String> fileTypes = List.of("xls", "xlsx");
        validatorFile(file, fileTypes);
    }

    private static void validatorFile(MultipartFile file, List<String> fileTypes) {
        // 文件为空
        if (file.isEmpty()) {
            throw new CustomException(ResultCodeEnum.FILE_IS_EMPTY);
        }
        String originalFilename = file.getOriginalFilename();
        // 文件名为空
        if (!StringUtils.hasText(originalFilename)) {
            throw new CustomException(ResultCodeEnum.FILE_NAME_IS_EMPTY);
        }
        // 文件类型错误
        if (!fileTypes.contains(originalFilename.substring(originalFilename.lastIndexOf(".") + 1))) {
            throw new CustomException(ResultCodeEnum.FILE_TYPE_ERROR);
        }
    }

}