package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.entity.dto.LogQueryDTO;
import com.briup.pai.service.ILogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Tag(name = "日志控制器")
public class LogController {

    @Resource
    private ILogService logService;

    @GetMapping("/{pageNum}/{pageSize}")
    @Operation(summary = "条件分页查询日志信息")
    public Result getLogByPageAndCondition(
            @PathVariable(value = "pageNum") Long pageNum,
            @PathVariable(value = "pageSize") Long pageSize,
            LogQueryDTO logQueryDTO) {
        return Result.success(logService.getLogByPageAndCondition(pageNum, pageSize, logQueryDTO));
    }

    @GetMapping("/export")
    @Operation(summary = "导出日志Excel")
    public void exportExcel(
            LogQueryDTO logQueryDTO,
            HttpServletResponse response) {
        logService.exportExcel(logQueryDTO, response);
    }
}