package com.briup.pai.common.utils;

import lombok.extern.slf4j.Slf4j;

// 短信发送工具类
@Slf4j
public class MessageUtil {

    /**
     * 发送短信验证码
     * <p>
     * 注意：当前为模拟发送，仅将验证码打印到日志，方便本地开发与调试。
     * 生产环境需要接入阿里云短信服务（dysmsapi20170525 依赖已引入），替换为真实的发送逻辑：
     * 使用 DefaultProfile + IAcsClient，需要 AccessKeyId / AccessKeySecret / 签名 / 模板码等配置。
     *
     * @param telephone 手机号码
     * @param code      验证码
     */
    public static void sendMessage(String telephone, int code) {
        // TODO 接入阿里云短信服务
        log.info("【模拟发送短信】手机号：{}，验证码：{}", telephone, code);
    }
}
