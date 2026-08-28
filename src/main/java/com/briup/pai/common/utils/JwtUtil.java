package com.briup.pai.common.utils;

import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.CustomException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@Data
public class JwtUtil {

    // 签名秘钥
    private static String signKey = "briup-pai";

    // 过期时间（一天）
    private static Long expire = 1000 * 60 * 60 * 24L;

    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分负载 payload中存储的 自定义信息
     * @return JWT字符串
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                // 自定义信息（有效载荷声明）
                .addClaims(claims)
                // 签名算法（头部）
                .signWith(SignatureAlgorithm.HS256, signKey)
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param jwt JWT字符串(令牌)
     * @return JWT第二部分负载 payload中存储的内容(自定义信息 Map集合)
     * 注意：解析时，令牌无效【1.null 2.签名不匹配 3.过期】，直接抛异常
     */
    public static Claims parseJWT(String jwt) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    // 指定签名秘钥
                    .setSigningKey(signKey)
                    // 指定JWT令牌
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new CustomException(ResultCodeEnum.USER_LOGIN_EXPIRATION);
        }
        // 如果执行到return，说明 令牌校验成功
        return claims;
    }

    // 提取userId
    public static Integer getUserId(String jwt) {
        Claims claims = parseJWT(jwt);
        return (Integer) claims.get("id");
    }
}