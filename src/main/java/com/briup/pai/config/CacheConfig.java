package com.briup.pai.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching // 开启缓存
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory lettuceConnectionFactory,
                                     Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                // 设置缓存过期时间（1天）
                .entryTtl(Duration.ofSeconds(24 * 60 * 60))
                // 设置key的序列化方式
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                // 设置value的序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                // 修改生成key的前缀（默认生成以::分隔）
                .computePrefixWith(cacheName -> cacheName + ":")
                // 禁用null值缓存
                .disableCachingNullValues();
        return RedisCacheManager
                .builder(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }
}
