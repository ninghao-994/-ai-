package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "发布模型VO")
public class ReleaseModelVO {

    @Schema(description = "模型编号")
    private Integer modelId;

    @Schema(description = "模型名称")
    private String modelName;

    @Schema(description = "模型描述")
    private String modelDesc;
}