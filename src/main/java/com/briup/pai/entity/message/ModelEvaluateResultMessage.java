package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "模型评估结果消息")
public class ModelEvaluateResultMessage extends ModelOperationResultMessage{

    @Schema(description = "模型编号")
    private Integer modelId;

    @Schema(description = "评估编号")
    private Integer evaluateId;

    @Schema(description = "评估错误信息")
    private List<EvaluateErrorMessage> evaluateErrors;
}
