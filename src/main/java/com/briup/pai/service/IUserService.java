package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.UserSaveDTO;
import com.briup.pai.entity.po.User;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.entity.vo.UserEchoVO;
import com.briup.pai.entity.vo.UserPageVO;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService extends IService<User> {

    // 根据用户Id获取用户名
    String getUsernameById(Integer userId);

    // 分页查询用户信息
    PageVO<UserPageVO> getUserByPageAndCondition(Long pageNum, Long pageSize, String keyword);

    // 添加或修改用户
    UserEchoVO addOrModifyUser(UserSaveDTO dto);

    // 用户上传头像
    String uploadProfilePicture(MultipartFile file);

    // 修改用户数据回显
    UserEchoVO getUserById(Integer userId);

    // 重置密码
    void resetPassword(Integer userId);

    // 删除用户
    void removeUserById(Integer userId);

    // 禁用或者启用用户
    void disableOrEnableUser(Integer userId, Integer status);
}