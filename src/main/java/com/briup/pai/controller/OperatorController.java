package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.entity.dto.OperatorUpdateDTO;
import com.briup.pai.service.IOperatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/operator")
@Tag(name = "算子控制器")
public class OperatorController {

    @Resource
    private IOperatorService operatorService;

    @PostMapping("/import")
    @Operation(summary = "导入算子信息")
    public Result importOperator(@RequestPart(value = "file") MultipartFile file) {
        operatorService.importOperator(file);
        return Result.success();
    }

    @GetMapping("/{pageNum}/{pageSize}")
    @Operation(summary = "条件分页查询算子信息")
    public Result getOperatorByPageAndCondition(
            @PathVariable(value = "pageNum") Long pageNum,
            @PathVariable(value = "pageSize") Long pageSize,
            @RequestParam(
                    value = "operatorType",
                    required = false,
                    defaultValue = "-1") Integer operatorType,
            @RequestParam(
                    value = "operatorCategory",
                    required = false,
                    defaultValue = "-1") Integer operatorCategory) {
        return Result.success(operatorService.getOperatorByPageAndCondition(pageNum, pageSize, operatorType, operatorCategory));
    }

    @GetMapping("/{operatorId}")
    @Operation(summary = "修改算子的数据回显")
    public Result queryOperatorById(
            @PathVariable(value = "operatorId") Integer operatorId) {
        return Result.success(operatorService.getOperatorById(operatorId));
    }

    @PutMapping
    @Operation(summary = "修改算子信息")
    public Result modifyOperatorById(
            @RequestBody
            @Valid OperatorUpdateDTO dto) {
        return Result.success(operatorService.modifyOperatorById(dto));
    }

    @DeleteMapping("/{operatorId}")
    @Operation(summary = "根据ID删除算子信息")
    public Result removeOperatorById(
            @PathVariable(value = "operatorId") Integer operatorId) {
        operatorService.removeOperatorById(operatorId);
        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "批量删除算子")
    public Result removeOperatorByIds(@RequestBody List<Integer> ids) {
        operatorService.removeOperatorByIds(ids);
        return Result.success();
    }

    @GetMapping("/getDropDownList")
    @Operation(summary = "查询算子下拉框信息")
    public Result getOperatorDropDownList() {
        return Result.success(operatorService.getOperatorDropDownList());
    }
}