package com.briup.pai.service;

import com.briup.pai.entity.dto.LoginWithPhoneDTO;
import com.briup.pai.entity.dto.LoginWithUsernameDTO;
import com.briup.pai.entity.vo.CurrentLoginUserVO;

public interface ILoginService {

    // 用户名密码登录
    String loginWithUsername(LoginWithUsernameDTO dto);

    // 获取当前登录用户
    CurrentLoginUserVO getCurrentUser();

    // 发送短信验证码
    void sendMessageCode(String telephone);

    // 手机号码登录
    String loginWithTelephone(LoginWithPhoneDTO dto);
}