package com.briup.pai.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.briup.pai.common.constant.LoginConstant;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.enums.UserStatusEnum;
import com.briup.pai.common.exception.BriupAssert;
import com.briup.pai.common.utils.JwtUtil;
import com.briup.pai.common.utils.MessageUtil;
import com.briup.pai.common.utils.RedisUtil;
import com.briup.pai.common.utils.SecurityUtil;
import com.briup.pai.convert.UserConvert;
import com.briup.pai.entity.dto.LoginWithPhoneDTO;
import com.briup.pai.entity.dto.LoginWithUsernameDTO;
import com.briup.pai.entity.po.User;
import com.briup.pai.entity.vo.CurrentLoginUserVO;
import com.briup.pai.service.ILoginService;
import com.briup.pai.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private IUserService userService;

    @Resource
    private UserConvert userConvert;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public String loginWithUsername(LoginWithUsernameDTO dto) {
        String username = dto.getUsername();
        // 用户名必须存在
        User user = BriupAssert.requireNotNull(userService, User::getUsername, username, ResultCodeEnum.USER_NOT_EXIST);
        // 密码必须正确（数据库中密码为MD5加密）
        String password = DigestUtils.md5DigestAsHex(dto.getPassword().getBytes());
        BriupAssert.requireEqual(password, user.getPassword(), ResultCodeEnum.PASSWORD_IS_WRONG);
        // 登录成功，生成JWT并返回
        Map<String, Object> map = new HashMap<>();
        map.put(LoginConstant.JWT_PAYLOAD_KEY, user.getId());
        return JwtUtil.generateJwt(map);
    }

    @Override
    public CurrentLoginUserVO getCurrentUser() {
        // 获取当前登录用户ID
        Integer userId = SecurityUtil.getUserId();
        // 查询当前登录用户
        User user = userService.getById(userId);
        // 转换对象返回（此处暂时不封装权限和路由）
        return userConvert.po2CurrentLoginUserVO(user);
    }

    @Override
    public void sendMessageCode(String telephone) {
        // 验证码在redis中的key和过期时间
        String verifyCodeKey = LoginConstant.USER_SMS_VERIFY_CODE_PREFIX + telephone;
        int expireTime = LoginConstant.USER_SMS_VERIFY_CODE_EXPIRATION_TIME;
        // 用户必须存在
        User user = BriupAssert.requireNotNull(userService, User::getTelephone, telephone, ResultCodeEnum.USER_NOT_EXIST);
        // 用户不能被禁用
        BriupAssert.requireEqual(user.getStatus(), UserStatusEnum.AVAILABLE.getStatus(), ResultCodeEnum.USER_IS_DISABLED);
        // 验证码必须不存在（防止重复发送）
        BriupAssert.requireFalse(redisUtil.existKey(verifyCodeKey), ResultCodeEnum.USER_VERIFY_CODE_ALREADY_EXIST);
        // 生成4位验证码
        int code = RandomUtil.randomInt(1000, 10000);
        // 发送验证码
        MessageUtil.sendMessage(telephone, code);
        // 保存验证码到redis
        redisUtil.set(verifyCodeKey, code, expireTime);
    }

    @Override
    public String loginWithTelephone(LoginWithPhoneDTO dto) {
        String phone = dto.getTelephone();
        Integer code = dto.getCode();
        // 用户必须存在
        User user = BriupAssert.requireNotNull(userService, User::getTelephone, phone, ResultCodeEnum.USER_NOT_EXIST);
        // 用户不能被禁用
        BriupAssert.requireEqual(user.getStatus(), UserStatusEnum.AVAILABLE.getStatus(), ResultCodeEnum.USER_IS_DISABLED);
        // 验证码必须存在
        String verifyCodeKey = LoginConstant.USER_SMS_VERIFY_CODE_PREFIX + phone;
        BriupAssert.requireTrue(redisUtil.existKey(verifyCodeKey), ResultCodeEnum.USER_VERIFY_CODE_NOT_EXIST);
        // 验证码必须一致
        Integer redisCode = (Integer) redisUtil.get(verifyCodeKey);
        BriupAssert.requireEqual(redisCode, code, ResultCodeEnum.USER_VERIFY_CODE_ERROR);
        // 登录成功，删除Redis验证码
        redisUtil.delete(verifyCodeKey);
        // 生成JWT并返回
        Map<String, Object> map = new HashMap<>();
        map.put(LoginConstant.JWT_PAYLOAD_KEY, user.getId());
        return JwtUtil.generateJwt(map);
    }
}
