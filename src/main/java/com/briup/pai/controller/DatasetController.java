package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.DatasetSaveDTO;
import com.briup.pai.service.IDatasetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataset")
@Tag(name = "数据集控制器")
public class DatasetController {

    @Resource
    private IDatasetService datasetService;

    @GetMapping("/{pageNum}/{pageSize}")
    @Operation(summary = "条件分页查询数据集")
    public Result getDatasetByPageAndCondition(
            @PathVariable(value = "pageNum") Long pageNum,
            @PathVariable(value = "pageSize") Long pageSize,
            @RequestParam(value = "datasetName", required = false) String datasetName,
            @RequestParam(value = "datasetType", required = false) Integer datasetType) {
        return Result.success(datasetService.getDatasetByPageAndCondition(pageNum, pageSize, datasetName, datasetType));
    }

    @PostMapping
    @Operation(summary = "新增数据集")
    public Result addDataset(
            @RequestBody
            @Validated(ValidatorGroups.insert.class) DatasetSaveDTO dto) {
        return Result.success(datasetService.addOrModifyDataset(dto));
    }

    @GetMapping("/{datasetId}")
    @Operation(summary = "修改数据集的数据回显")
    public Result getDatasetById(
            @PathVariable(value = "datasetId") Integer datasetId) {
        return Result.success(datasetService.modifyDatasetFeedback(datasetId));
    }

    @PutMapping
    @Operation(summary = "修改数据集")
    public Result modifyDatasetById(
            @RequestBody
            @Validated(ValidatorGroups.update.class) DatasetSaveDTO dto) {
        return Result.success(datasetService.addOrModifyDataset(dto));
    }

    @DeleteMapping("/{datasetId}")
    @Operation(summary = "根据数据集ID删除数据集")
    public Result removeDatasetById(
            @PathVariable(value = "datasetId") Integer datasetId) {
        datasetService.removeDatasetById(datasetId);
        return Result.success();
    }

    @GetMapping("/detail/{datasetId}")
    @Operation(summary = "根据ID查询数据集详情信息")
    public Result getDatasetDetail(
            @PathVariable(value = "datasetId") Integer datasetId) {
        return Result.success(datasetService.getDatasetDetail(datasetId));
    }
}