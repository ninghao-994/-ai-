package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.service.IIndexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@Tag(name = "首页大屏控制器")
public class IndexController {

    @Resource
    private IIndexService indexService;

    @GetMapping("/getChartData")
    @Operation(summary = "查询首页数据")
    public Result getChartData() {
        return Result.success(indexService.getModelChartData());
    }
}