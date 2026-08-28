package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "模型柱状图VO")
public class ModelChartVO {

    @Schema(description = "训练中模型数量")
    private Long initCount;

    @Schema(description = "优化中模型数量")
    private Long optimizeCount;
}
