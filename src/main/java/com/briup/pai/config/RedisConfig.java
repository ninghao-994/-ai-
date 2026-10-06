package com.briup.pai.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory,
                                                       Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
        // 创建RedisTemplate
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(lettuceConnectionFactory);
        // 配置key和value的序列化模式
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // 配置hash key和hash value的序列化模式
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置对象映射器的可见性，使所有属性都可以被序列化和反序列化
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 启用默认类型信息，以便在序列化和反序列化时处理多态情况
        objectMapper.activateDefaultTyping(
                // 使用 LaissezFaireSubTypeValidator 允许所有类型的反序列化
                LaissezFaireSubTypeValidator.instance,
                // 设置默认类型检测策略为 NON_FINAL，即对非最终类进行类型检测
                ObjectMapper.DefaultTyping.NON_FINAL,
                // 设置类型信息存储方式为 PROPERTY，即将类型信息作为属性存储在 JSON 中
                JsonTypeInfo.As.PROPERTY
        );
        // 使用 Jackson2JsonRedisSerializer 来序列化和反序列化
        return new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
    }
}
