package com.briup.pai.common.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

// Redis操作工具类
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /* key相关操作 */

    // 判断key是否存在
    public Boolean existKey(String key) {
        return redisTemplate.hasKey(key);
    }

    // 删除key
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /* string类型相关操作 */

    // 设置string类型的值，带过期时间，单位：秒
    public void set(String key, Object value, int expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    // 获取string类型的值
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
