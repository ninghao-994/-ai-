package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "模型历史VO")
public class ModelHistoryVO {

    @Schema(description = "模型训练版本")
    private Integer modelVersion;

    @Schema(description = "所用数据集名称")
    private List<String> datasetNames;

    @Schema(description = "模型准确率")
    private Double accuracyRate;

    @Schema(description = "训练时间")
    private Date trainDate;

    @Schema(description = "训练结果")
    private List<ModelOperationResultVO> trainResults;

    @Schema(description = "评估报告")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ModelEvaluateReportVO> evaluateReport;
}