package com.briup.pai.convert;

import com.briup.pai.common.utils.SecurityUtil;
import com.briup.pai.common.utils.SpringContextUtil;
import com.briup.pai.service.IDictionaryService;
import com.briup.pai.service.IUserService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseConvert {

    BaseConvert INSTANCE = Mappers.getMapper(BaseConvert.class);

    // 获取创建用户名
    default String getCreateUser(Integer userId) {
        if (userId == null) {
            return null;
        }
        return SpringContextUtil.getBean(IUserService.class).getUsernameById(userId);
    }

    // 获取创建用户Id
    default Integer getCreateUserId() {
        return SecurityUtil.getUserId();
    }

    // 获取数据字典值
    default String getDictionaryValue(Integer dictionaryId) {
        if (dictionaryId == null) {
            return null;
        }
        return SpringContextUtil.getBean(IDictionaryService.class).getDictionaryValueById(dictionaryId);
    }
}
