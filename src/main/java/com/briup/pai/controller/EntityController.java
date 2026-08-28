package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.service.IEntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entity")
@Tag(name = "实体控制器")
public class EntityController {

    @Resource
    private IEntityService entityService;

    @GetMapping("/{classifyId}/{pageNum}")
    @Operation(summary = "分页展示实体图片")
    public Result getEntityInClassifyByPage(
            @PathVariable(value = "classifyId") Integer classifyId,
            @PathVariable(value = "pageNum") Long pageNum) {
        return Result.success(entityService.getEntityByPage(classifyId, pageNum));
    }

    @DeleteMapping("/{datasetId}/{classifyId}")
    @Operation(summary = "批量删除实体图片")
    public Result removeEntityByBatch(
            @PathVariable(value = "datasetId") Integer datasetId,
            @PathVariable(value = "classifyId") Integer classifyId,
            @RequestBody List<Integer> entityIds) {
        entityService.removeEntityByBatch(datasetId, classifyId, entityIds);
        return Result.success();
    }
}