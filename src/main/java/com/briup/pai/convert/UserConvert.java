package com.briup.pai.convert;

import com.briup.pai.entity.dto.UserSaveDTO;
import com.briup.pai.entity.po.User;
import com.briup.pai.entity.vo.CurrentLoginUserVO;
import com.briup.pai.entity.vo.UserEchoVO;
import com.briup.pai.entity.vo.UserPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConvert {

    // User -> CurrentLoginUserVO
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "menu", ignore = true)
    @Mapping(target = "buttons", ignore = true)
    CurrentLoginUserVO po2CurrentLoginUserVO(User user);

    // User -> UserPageVO
    @Mapping(target = "userId", source = "id")
    UserPageVO po2UserPageVO(User user);

    // List<User> -> List<UserPageVO>
    List<UserPageVO> po2UserPageVOList(List<User> users);

    // UserSaveDTO -> User
    @Mapping(target = "id", source = "userId")
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    User userSaveDTO2Po(UserSaveDTO dto);

    // User -> UserEchoVO
    @Mapping(target = "userId", source = "id")
    UserEchoVO po2UserEchoVO(User user);
}
