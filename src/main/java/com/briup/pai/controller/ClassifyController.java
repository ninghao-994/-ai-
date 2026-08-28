package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.ClassifySaveDTO;
import com.briup.pai.service.IClassifyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classify")
@Tag(name = "数据集分类控制器")
public class ClassifyController {

    @Resource
    private IClassifyService classifyService;

    @PostMapping
    @Operation(summary = "新增数据集分类")
    public Result addClassify(
            @RequestBody
            @Validated(ValidatorGroups.insert.class) ClassifySaveDTO dto) {
        return Result.success(classifyService.addOrModifyClassify(dto));
    }

    @GetMapping("/{classifyId}")
    @Operation(summary = "修改数据集分类的数据回显")
    public Result getClassifyById(
            @PathVariable(value = "classifyId") Integer classifyId) {
        return Result.success(classifyService.getClassifyById(classifyId));
    }

    @PutMapping
    @Operation(summary = "修改数据集分类")
    public Result modifyClassifyById(
            @RequestBody
            @Validated(ValidatorGroups.update.class) ClassifySaveDTO dto) {
        return Result.success(classifyService.addOrModifyClassify(dto));
    }

    @DeleteMapping("/{datasetId}/{classifyId}")
    @Operation(summary = "根据Id删除数据集分类")
    public Result removeClassifyById(
            @PathVariable(value = "datasetId") Integer datasetId,
            @PathVariable(value = "classifyId") Integer classifyId) {
        classifyService.removeClassifyById(datasetId, classifyId);
        return Result.success();
    }
}