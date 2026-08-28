package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "模型操作结果VO")
public class ModelOperationResultVO {

    @Schema(description = "训练标签的名称")
    private String labelName;

    @Schema(description = "训练指标：F1Score")
    private BigDecimal f1Score;

    @Schema(description = "训练指标：GScore")
    private BigDecimal gScore;

    @Schema(description = "训练指标：精确率")
    private BigDecimal precisionRate;

    @Schema(description = "训练指标：召回率")
    private BigDecimal recallRate;
}
