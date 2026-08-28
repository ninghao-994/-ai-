package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "模型评估消息")
public class ModelEvaluateMessage extends ModelOperationMessage{

    @Schema(description = "评估编号")
    private Integer evaluateId;

    @Schema(description = "模型文件地址")
    private String modelFileAddr;
}
