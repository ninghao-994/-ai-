package com.briup.pai.service.impl;

import com.briup.pai.entity.dto.ModelOperationDTO;
import com.briup.pai.entity.po.ModelConfig;
import com.briup.pai.entity.vo.ReleaseModelVO;
import com.briup.pai.entity.vo.TrainingDatasetQueryVO;
import com.briup.pai.service.IModelOperationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ModelOperationServiceImpl implements IModelOperationService {

    @Override
    public List<TrainingDatasetQueryVO> getTrainingDatasets(Integer modelId, Integer datasetUsage) {
        return List.of();
    }

    @Override
    public ModelConfig getModelConfig(Integer modelId) {
        return null;
    }

    @Override
    public void operationModel(ModelOperationDTO modelOperationDTO) {

    }

    @Override
    public void releaseModelOrNot(Integer modelId, Integer modelStatus) {

    }

    @Override
    public List<ReleaseModelVO> getReleaseModel() {
        return List.of();
    }

    @Override
    public String identify(Integer modelId, MultipartFile file) {
        return "";
    }
}