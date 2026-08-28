package com.briup.pai.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Schema(description = "日志查询DTO")
public class LogQueryDTO {

    @Schema(description = "日志类型")
    private Integer type;

    @Schema(description = "是否成功")
    private Integer isSuccess;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
