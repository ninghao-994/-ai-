package com.briup.pai.service.impl;

import com.briup.pai.entity.dto.LoginWithPhoneDTO;
import com.briup.pai.entity.dto.LoginWithUsernameDTO;
import com.briup.pai.entity.vo.CurrentLoginUserVO;
import com.briup.pai.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public String loginWithUsername(LoginWithUsernameDTO dto) {
        return "";
    }

    @Override
    public CurrentLoginUserVO getCurrentUser() {
        return null;
    }

    @Override
    public void sendMessageCode(String telephone) {

    }

    @Override
    public String loginWithTelephone(LoginWithPhoneDTO dto) {
        return "";
    }
}