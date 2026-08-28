package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "模型发布消息")
public class ModelReleaseMessage {

    @Schema(description = "发布用户ID")
    private Integer userId;

    @Schema(description = "模型ID")
    private Integer modelId;

    @Schema(description = "模型状态")
    private Integer modelStatus;

    @Schema(description = "模型文件地址")
    private String modelFileAddr;
}
