package com.briup.pai.convert;

import com.briup.pai.entity.po.Entity;
import com.briup.pai.entity.vo.EntityInClassifyVO;
import com.briup.pai.entity.vo.EntityPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityConvert {

    // Entity -> EntityInClassifyVO
    @Mapping(target = "entityId", source = "id")
    EntityInClassifyVO po2EntityInClassifyVO(Entity entity);

    // List<Entity> -> List<EntityInClassifyVO>
    List<EntityInClassifyVO> po2EntityInClassifyVOList(List<Entity> entities);

    // Entity -> EntityPageVO
    @Mapping(target = "entityId", source = "id")
    EntityPageVO po2EntityPageVO(Entity entity);

    // List<Entity> -> List<EntityPageVO>
    List<EntityPageVO> po2EntityPageVOList(List<Entity> entities);
}
