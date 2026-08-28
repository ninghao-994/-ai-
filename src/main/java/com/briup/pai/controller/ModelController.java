package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.ModelSaveDTO;
import com.briup.pai.service.IModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
@Tag(name = "模型控制器")
public class ModelController {

    @Resource
    private IModelService modelService;

    @GetMapping("/pageAndCondition/{pageNum}")
    @Operation(summary = "条件分页查询所有模型")
    public Result getModelByPageAndCondition(
            @PathVariable(value = "pageNum") Integer pageNum,
            @RequestParam(value = "modelType", required = false) Integer modelType) {
        return Result.success(modelService.getModelByPageAndCondition(pageNum, modelType));
    }

    @PostMapping
    @Operation(summary = "新增模型")
    public Result addModel(
            @RequestBody
            @Validated(ValidatorGroups.insert.class) ModelSaveDTO modelSaveDTO) {
        return Result.success(modelService.addAndModifyModel(modelSaveDTO));
    }

    @GetMapping("/{modelId}")
    @Operation(summary = "修改模型的数据回显")
    public Result getModelById(
            @PathVariable(value = "modelId") Integer modelId) {
        return Result.success(modelService.getModelById(modelId));
    }

    @PutMapping
    @Operation(summary = "根据Id修改模型")
    public Result modifyModelById(
            @RequestBody
            @Validated(ValidatorGroups.update.class) ModelSaveDTO modelSaveDTO) {
        return Result.success(modelService.addAndModifyModel(modelSaveDTO));
    }

    @DeleteMapping("/{modelId}")
    @Operation(summary = "根据Id删除模型")
    public Result removeModelById(
            @PathVariable(value = "modelId") Integer modelId) {
        modelService.removeModelById(modelId);
        return Result.success();
    }

    @GetMapping("/detail/{modelId}")
    @Operation(summary = "根据Id查询模型详情")
    public Result getModelDetailById(
            @PathVariable(value = "modelId") Integer modelId) {
        return Result.success(modelService.getModelDetailById(modelId));
    }
}