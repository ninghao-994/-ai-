package com.briup.pai.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "日志导出DTO")
public class LogExportDTO {

    @ExcelProperty(value = "日志编号", index = 0)
    @Schema(description = "日志编号")
    private Integer id;

    @ExcelProperty(value = "日志类型", index = 1)
    @Schema(description = "日志类型")
    private String type;

    @ExcelProperty(value = "请求URI", index = 2)
    @Schema(description = "请求URI")
    private String requestUri;

    @ExcelProperty(value = "请求方式", index = 3)
    @Schema(description = "请求方式")
    private String requestMethod;

    @ExcelProperty(value = "请求IP地址", index = 4)
    @Schema(description = "请求IP地址")
    private String requestIp;

    @ExcelProperty(value = "请求参数", index = 5)
    @Schema(description = "请求参数")
    private String requestParams;

    @ExcelProperty(value = "方法名称", index = 6)
    @Schema(description = "方法名称")
    private String methodName;

    @ExcelProperty(value = "请求耗时", index = 7)
    @Schema(description = "请求耗时")
    private Long requestTime;

    @ExcelProperty(value = "是否成功", index = 8)
    @Schema(description = "是否成功")
    private String isSuccess;

    @ExcelProperty(value = "响应数据", index = 9)
    @Schema(description = "响应数据")
    private String responseData;

    @ExcelProperty(value = "请求时间", index = 10)
    @Schema(description = "请求时间")
    private Date operateTime;

    @ExcelProperty(value = "请求用户", index = 11)
    @Schema(description = "请求用户")
    private String operateUser;
}