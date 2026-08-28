package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "算子数据回显VO")
public class OperatorEchoVO {

    @Schema(description = "算子编号")
    private Integer operatorId;

    @Schema(description = "算子名称")
    private String operatorName;

    @Schema(description = "程序路径")
    private String operatorUrl;
}
