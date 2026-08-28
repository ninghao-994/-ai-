package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.ModelOperationDTO;
import com.briup.pai.service.IModelOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/model/operation")
@Tag(name = "模型操作控制器")
public class ModelOperationController {

    @Resource
    private IModelOperationService modelOperationService;

    @GetMapping("/getTrainingDatasets/{modelId}/{datasetUsage}")
    @Operation(summary = "根据Id获取训练能够使用的数据集")
    public Result getTrainingDatasets(
            @PathVariable(value = "modelId") Integer modelId,
            @PathVariable(value = "datasetUsage") Integer datasetUsage) {
        return Result.success(modelOperationService.getTrainingDatasets(modelId, datasetUsage));
    }

    @GetMapping("/config/{modelId}")
    @Operation(summary = "根据Id获取模型对应配置信息")
    public Result getModelConfig(
            @PathVariable(value = "modelId") Integer modelId) {
        return Result.success(modelOperationService.getModelConfig(modelId));
    }

    @PostMapping("/train")
    @Operation(summary = "模型训练")
    public Result modelTrain(
            @RequestBody
            @Validated(ValidatorGroups.train.class) ModelOperationDTO modelOperationDTO) {
        modelOperationService.operationModel(modelOperationDTO);
        return Result.success();
    }

    @PostMapping("/evaluate")
    @Operation(summary = "模型评估")
    public Result modelEvaluate(
            @RequestBody
            @Validated(ValidatorGroups.evaluate.class) ModelOperationDTO modelOperationDTO) {
        modelOperationService.operationModel(modelOperationDTO);
        return Result.success();
    }

    @PostMapping("/release/{modelId}/{modelStatus}")
    @Operation(summary = "发布或者取消发布模型")
    public Result releaseModelOrNot(
            @PathVariable(value = "modelId") Integer modelId,
            @PathVariable(value = "modelStatus") Integer modelStatus) {
        modelOperationService.releaseModelOrNot(modelId, modelStatus);
        return Result.success();
    }

    @GetMapping("/getReleaseModel")
    @Operation(summary = "查询已经发布的模型")
    public Result getReleaseModel() {
        return Result.success(modelOperationService.getReleaseModel());
    }

    @PostMapping("/identify/{modelId}")
    @Operation(summary = "病虫害识别")
    public Result identify(
            @PathVariable(value = "modelId") Integer modelId,
            @RequestPart(value = "file") MultipartFile file) {
        return Result.success(modelOperationService.identify(modelId, file));
    }
}
