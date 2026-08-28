package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.ModelMapper;
import com.briup.pai.entity.dto.ModelSaveDTO;
import com.briup.pai.entity.po.Model;
import com.briup.pai.entity.vo.ModelDetailVO;
import com.briup.pai.entity.vo.ModelEchoVO;
import com.briup.pai.entity.vo.ModelPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements IModelService {

    @Override
    public PageVO<ModelPageVO> getModelByPageAndCondition(Integer pageNum, Integer modelType) {
        return null;
    }

    @Override
    public ModelEchoVO getModelById(Integer modelId) {
        return null;
    }

    @Override
    public ModelEchoVO addAndModifyModel(ModelSaveDTO modelSaveDTO) {
        return null;
    }

    @Override
    public void removeModelById(Integer modelId) {

    }

    @Override
    public ModelDetailVO getModelDetailById(Integer modelId) {
        return null;
    }

    @Override
    public List<Integer> getDatasetIdsUsed() {
        return List.of();
    }
}