package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "模型训练结果消息")
public class ModelTrainResultMessage extends ModelOperationResultMessage {

    @Schema(description = "是否训练成功")
    private Integer isSuccess;

    @Schema(description = "训练编号")
    private Integer trainingId;

    @Schema(description = "对应模型训练后的模型文件地址")
    private String modelFileAddr;
}