package com.briup.pai.common.utils;

// 当前登录用户上下文工具类（基于ThreadLocal实现用户身份传递）
public class SecurityUtil {

    // 保存当前登录用户Id
    private static final ThreadLocal<Integer> USER_ID_THREAD_LOCAL = new ThreadLocal<>();

    // 获取当前登录用户Id
    public static Integer getUserId() {
        return USER_ID_THREAD_LOCAL.get();
    }

    // 设置当前登录用户Id
    public static void setUserId(Integer userId) {
        USER_ID_THREAD_LOCAL.set(userId);
    }

    // 移除当前登录用户Id（请求结束后调用，防止内存泄漏）
    public static void remove() {
        USER_ID_THREAD_LOCAL.remove();
    }
}
