package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分页查询数据集VO")
public class DatasetPageVO {
    @Schema(description = "数据集编号")
    private Integer datasetId;

    @Schema(description = "数据集名称")
    private String datasetName;

    @Schema(description = "数据集类型")
    private String datasetType;

    @Schema(description = "数据集状态")
    private String datasetStatus;

    @Schema(description = "数据集用途")
    private String datasetUsage;

    @Schema(description = "数据集下分类数量")
    private Long classifyNum;

    @Schema(description = "数据集下实体图片数量")
    private Long entityNum;
}