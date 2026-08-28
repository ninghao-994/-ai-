package com.briup.pai.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseConvert {

    BaseConvert INSTANCE = Mappers.getMapper(BaseConvert.class);

    // 获取创建用户名
    default String getCreateUser(Integer userId) {
        return "";
    }

    // 获取创建用户Id
    default Integer getCreateUserId() {
        return 0;
    }

    // 获取数据字典值
    default String getDictionaryValue(Integer dictionaryId) {
        return "";
    }
}
