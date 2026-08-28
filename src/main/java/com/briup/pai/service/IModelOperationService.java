package com.briup.pai.service;

import com.briup.pai.entity.dto.ModelOperationDTO;
import com.briup.pai.entity.po.ModelConfig;
import com.briup.pai.entity.vo.ReleaseModelVO;
import com.briup.pai.entity.vo.TrainingDatasetQueryVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IModelOperationService {

    // 获取训练使用的数据集
    List<TrainingDatasetQueryVO> getTrainingDatasets(Integer modelId, Integer datasetUsage);

    // 获取模型配置
    ModelConfig getModelConfig(Integer modelId);

    // 模型训练
    void operationModel(ModelOperationDTO modelOperationDTO);

    // 发布模型
    void releaseModelOrNot(Integer modelId, Integer modelStatus);

    // 查询发布的模型
    List<ReleaseModelVO> getReleaseModel();

    // 模型识别
    String identify(Integer modelId, MultipartFile file);
}