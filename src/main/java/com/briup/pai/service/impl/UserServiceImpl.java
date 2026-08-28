package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.UserMapper;
import com.briup.pai.entity.dto.UserSaveDTO;
import com.briup.pai.entity.po.User;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.entity.vo.UserEchoVO;
import com.briup.pai.entity.vo.UserPageVO;
import com.briup.pai.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public String getUsernameById(Integer userId) {
        return "";
    }

    @Override
    public PageVO<UserPageVO> getUserByPageAndCondition(Long pageNum, Long pageSize, String keyword) {
        return null;
    }

    @Override
    public UserEchoVO addOrModifyUser(UserSaveDTO dto) {
        return null;
    }

    @Override
    public String uploadProfilePicture(MultipartFile file) {
        return "";
    }

    @Override
    public UserEchoVO getUserById(Integer userId) {
        return null;
    }

    @Override
    public void resetPassword(Integer userId) {

    }

    @Override
    public void removeUserById(Integer userId) {

    }

    @Override
    public void disableOrEnableUser(Integer userId, Integer status) {

    }
}