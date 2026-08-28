package com.briup.pai.convert;

import com.briup.pai.entity.message.ModelReleaseResultMessage;
import com.briup.pai.entity.po.Release;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReleaseConvert {

    // ModelReleaseResultDTO -> Release
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "createBy", source = "userId")
    Release modelReleaseResultMessage2Po(ModelReleaseResultMessage modelReleaseResultMessage);
}
