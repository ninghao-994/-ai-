package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.EntityMapper;
import com.briup.pai.entity.po.Entity;
import com.briup.pai.entity.vo.EntityInClassifyVO;
import com.briup.pai.entity.vo.EntityPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements IEntityService {

    @Override
    public List<EntityInClassifyVO> getEntityByClassifyId(Integer classifyId) {
        return List.of();
    }

    @Override
    public PageVO<EntityPageVO> getEntityByPage(Integer classifyId, Long pageNum) {
        return null;
    }

    @Override
    public void removeEntityByBatch(Integer datasetId, Integer classifyId, List<Integer> entityIds) {

    }
}