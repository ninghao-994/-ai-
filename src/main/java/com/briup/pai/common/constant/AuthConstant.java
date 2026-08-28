package com.briup.pai.common.constant;

// 权限模块缓存相关常量
public class AuthConstant {

    // 授权缓存前缀
    public static final String AUTH_CACHE_PREFIX = "Auth";

    // 用户缓存前缀
    public static final String USER_CACHE_PREFIX = "User";

    // 创建用户用户名缓存前缀
    public static final String CREATE_USERNAME_CACHE_PREFIX = "CreateUserName";

    // 角色缓存前缀
    public static final String ROLE_CACHE_PREFIX = "Role";

    // 所有角色缓存key
    public static final String GET_ALL_ROLES_CACHE_KEY = ROLE_CACHE_PREFIX + ":" + CommonConstant.LIST_CACHE_PREFIX;

    // 用户角色列表缓存前缀
    public static final String USER_ROLE_CACHE_PREFIX = "UserRole";

    // 权限缓存前缀
    public static final String PERMISSION_CACHE_PREFIX = "Permission";

    // 所有权限缓存key
    public static final String GET_ALL_PERMISSION_CACHE_KEY = PERMISSION_CACHE_PREFIX + ":" + CommonConstant.LIST_CACHE_PREFIX;

    // 角色权限列表缓存前缀
    public static final String ROLE_PERMISSION_CACHE_PREFIX = "RolePermission";

    // 路由缓存前缀
    public static final String ROUTER_CACHE_PREFIX = "Router";

    // 按钮权限前缀
    public static final String BUTTON_CACHE_PREFIX = "Button";
}
