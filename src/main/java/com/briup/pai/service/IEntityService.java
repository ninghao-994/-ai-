package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.po.Entity;
import com.briup.pai.entity.vo.EntityInClassifyVO;
import com.briup.pai.entity.vo.EntityPageVO;
import com.briup.pai.entity.vo.PageVO;

import java.util.List;

public interface IEntityService extends IService<Entity> {

    // 根据分类Id查询实体信息
    List<EntityInClassifyVO> getEntityByClassifyId(Integer classifyId);

    // 分页查询图片数据
    PageVO<EntityPageVO> getEntityByPage(Integer classifyId, Long pageNum);

    // 批量删除图片
    void removeEntityByBatch(Integer datasetId, Integer classifyId, List<Integer> entityIds);
}