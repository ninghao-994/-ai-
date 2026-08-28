package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.ModelSaveDTO;
import com.briup.pai.entity.po.Model;
import com.briup.pai.entity.vo.ModelDetailVO;
import com.briup.pai.entity.vo.ModelEchoVO;
import com.briup.pai.entity.vo.ModelPageVO;
import com.briup.pai.entity.vo.PageVO;

import java.util.List;

public interface IModelService extends IService<Model> {

    // 分页条件查询模型数据
    PageVO<ModelPageVO> getModelByPageAndCondition(Integer pageNum, Integer modelType);

    // 模型数据回显
    ModelEchoVO getModelById(Integer modelId);

    // 添加或修改模型
    ModelEchoVO addAndModifyModel(ModelSaveDTO modelSaveDTO);

    // 根据模型ID删除模型
    void removeModelById(Integer modelId);

    // 查询模型详情
    ModelDetailVO getModelDetailById(Integer modelId);

    // 根据模型Id查询正在使用的数据集ID
    List<Integer> getDatasetIdsUsed();
}