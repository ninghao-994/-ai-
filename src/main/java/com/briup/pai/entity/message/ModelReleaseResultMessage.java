package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "模型发布结果消息")
public class ModelReleaseResultMessage {

    @Schema(description = "发布用户Id")
    private Integer userId;

    @Schema(description = "模型Id")
    private Integer modelId;

    @Schema(description = "模型状态")
    private Integer modelStatus;

    @Schema(description = "模型发布地址")
    private String modelUrl;
}
