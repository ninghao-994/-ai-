package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(name = "LogPageVO", description = "日志条件分页查询VO")
public class LogPageVO {

    @Schema(description = "日志编号")
    private Integer id;

    @Schema(description = "日志类型")
    private String type;

    @Schema(description = "请求URI")
    private String requestUri;

    @Schema(description = "请求方式")
    private String requestMethod;

    @Schema(description = "请求IP")
    private String requestIp;

    @Schema(description = "请求参数")
    private String requestParams;

    @Schema(description = "方法名称")
    private String methodName;

    @Schema(description = "请求耗时")
    private Long requestTime;

    @Schema(description = "是否成功")
    private String isSuccess;

    @Schema(description = "响应数据")
    private String responseData;

    @Schema(description = "操作时间")
    private Date operateTime;

    @Schema(description = "操作人")
    private String operateUser;
}
