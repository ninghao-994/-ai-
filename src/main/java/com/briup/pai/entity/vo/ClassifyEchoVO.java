package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分类数据回显VO")
public class ClassifyEchoVO {

    @Schema(description = "分类ID")
    private Integer classifyId;

    @Schema(description = "分类名称")
    private String classifyName;
}
