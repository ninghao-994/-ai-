package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "模型数据回显VO")
public class ModelDetailVO {

    @Schema(description = "模型ID")
    private String modelId;

    @Schema(description = "模型名称")
    private String modelName;

    @Schema(description = "模型状态")
    private String modelStatus;

    @Schema(description = "模型描述")
    private String modelDesc;

    @Schema(description = "模型类型")
    private String modelType;

    @Schema(description = "模型最新版本")
    private Integer lastModelVersion;

    @Schema(description = "模型训练状态")
    private String trainingStatus;

    @Schema(description = "模型训练的准确率")
    private Double accuracyRate;

    @Schema(description = "模型训练的历史记录")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ModelHistoryVO> trainingHistory;
}