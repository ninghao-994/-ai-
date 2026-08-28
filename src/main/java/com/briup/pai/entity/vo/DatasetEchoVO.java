package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "数据集修改VO")
public class DatasetEchoVO {

    @Schema(description = "数据集ID")
    private Integer datasetId;

    @Schema(description = "数据集名称")
    private String datasetName;

    @Schema(description = "数据集类型")
    private Integer datasetType;

    @Schema(description = "数据集用途")
    private Integer datasetUsage;

    @Schema(description = "数据集详情")
    private String datasetDesc;
}
