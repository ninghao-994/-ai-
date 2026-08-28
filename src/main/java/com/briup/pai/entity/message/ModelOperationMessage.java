package com.briup.pai.entity.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Schema(description = "模型操作消息")
public class ModelOperationMessage {

    @Schema(description = "模型编号")
    private Integer modelId;

    @Schema(description = "训练用到的分类和图片")
    private Map<String, List<String>> data;
}