package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "模型数据回显VO")
public class ModelEchoVO {

    @Schema(description = "模型ID")
    private Integer modelId;

    @Schema(description = "模型名称")
    private String modelName;

    @Schema(description = "模型类型")
    private Integer modelType;

    @Schema(description = "模型描述")
    private String modelDesc;
}
