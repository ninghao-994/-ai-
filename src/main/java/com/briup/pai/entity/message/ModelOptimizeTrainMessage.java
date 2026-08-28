package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "模型优化训练消息")
public class ModelOptimizeTrainMessage extends ModelInitTrainMessage {

    @Schema(description = "原模型文件地址")
    private String oldModelPath;
}