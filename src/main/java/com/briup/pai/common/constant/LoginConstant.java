package com.briup.pai.common.constant;

// 登录缓存相关常量
public class LoginConstant {

    // 短信验证码存入redis的前缀
    public static final String USER_SMS_VERIFY_CODE_PREFIX= "VerifyCode";

    // 短信验证码过期时间（60s有效）
    public static final int USER_SMS_VERIFY_CODE_EXPIRATION_TIME = 60;

    // Token名称
    public static final String TOKEN_NAME = "Authorization";

    // JWT存放Id前缀
    public static final String JWT_PAYLOAD_KEY = "id";

    // 用户手机号码校验正则表达式
    public static final String USER_TELEPHONE_REGEX = "^[1][3,4,5,6,7,8,9][0-9]{9}$";

    // 初始密码
    public static final String INIT_PASSWORD = "123456";

    // 初始化头像地址
    public static final String INIT_HEADER_URL = "https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg";
}
