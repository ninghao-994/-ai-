package com.briup.pai.config;

import com.briup.pai.common.constant.LoginConstant;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.common.utils.JwtUtil;
import com.briup.pai.common.utils.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

// JWT令牌认证拦截器
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 从请求头中获取令牌
        String token = request.getHeader(LoginConstant.TOKEN_NAME);
        // 令牌为空，说明用户未登录
        BriupAssert.requireTrue(StringUtils.hasText(token), ResultCodeEnum.USER_NOT_LOGIN);
        // 解析令牌获取用户Id（令牌无效、过期时JwtUtil会抛出异常）
        Integer userId = JwtUtil.getUserId(token);
        // 将用户Id放入ThreadLocal，供后续业务使用
        SecurityUtil.setUserId(userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 请求结束后移除ThreadLocal中的用户信息，防止内存泄漏
        SecurityUtil.remove();
    }
}
