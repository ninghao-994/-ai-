package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "模型分页VO")
public class ModelPageVO {

    @Schema(description = "模型编号")
    private Integer modelId;

    @Schema(description = "模型名称")
    private String modelName;

    @Schema(description = "模型状态")
    private String modelStatus;

    @Schema(description = "模型类型")
    private String modelType;

    @Schema(description = "模型最后版本")
    private String lastModelVersion;

    @Schema(description = "训练状态")
    private String trainingStatus;

    @Schema(description = "模型准确率")
    private Double accuracyRate;
}
