package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "评估错误消息")
public class EvaluateErrorMessage {

    @Schema(description = "图片地址")
    private String picAddress;

    @Schema(description = "图片原始标签")
    private String oldLabel;

    @Schema(description = "图片识别标签")
    private String newLabel;
}
