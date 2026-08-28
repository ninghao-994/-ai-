package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "数据集下分类VO")
public class ClassifyInDatasetVO {

    @Schema(description = "分类ID")
    private Integer classifyId;

    @Schema(description = "分类名称")
    private String classifyName;

    @Schema(description = "分类下实体数量")
    private Long entityNum;
}