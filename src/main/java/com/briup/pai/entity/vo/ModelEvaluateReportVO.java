package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "模型评估结果VO")
public class ModelEvaluateReportVO {

    @Schema(description = "评估使用的数据集名称")
    private String datasetName;

    @Schema(description = "评估的准确率")
    private Double accuracyRate;

    @Schema(description = "评估的错误图片数量")
    private Long errorCount;

    @Schema(description = "评估的结果")
    private List<ModelOperationResultVO> evaluateResults;
}