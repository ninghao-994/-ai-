package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "模型操作结果消息")
public class ModelOperationResultMessage {

    @Schema(description = "模型编号")
    private Integer modelId;

    @Schema(description = "模型训练的准确率")
    private Double accuracyRate;

    @Schema(description = "模型训练对应各个指标的结果")
    private List<LabelResultMessage> labelResults;
}