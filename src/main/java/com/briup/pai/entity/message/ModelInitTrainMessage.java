package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "模型初始化训练消息")
public class ModelInitTrainMessage extends ModelOperationMessage {

    @Schema(description = "模型版本")
    private Integer modelVersion;

    @Schema(description = "训练编号")
    private Integer trainingId;

    @Schema(description = "训练参数：分辨率")
    private String resolution;

    @Schema(description = "训练参数：迭代次数")
    private String iterateTimes;

    @Schema(description = "训练参数：网络结构")
    private String networkStructure;

    @Schema(description = "训练参数：优化器")
    private String optimizer;

    @Schema(description = "训练参数：损失值")
    private String lossValue;
}