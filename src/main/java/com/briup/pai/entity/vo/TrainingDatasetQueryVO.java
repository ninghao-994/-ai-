package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "训练数据集查询VO对象")
public class TrainingDatasetQueryVO {

    @Schema(description = "数据集ID")
    private Integer datasetId;

    @Schema(description = "数据集名称")
    private String datasetName;
}