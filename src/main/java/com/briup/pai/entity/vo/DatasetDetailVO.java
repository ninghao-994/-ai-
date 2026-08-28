package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "数据集详情VO")
public class DatasetDetailVO {
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

    @Schema(description = "数据集描述")
    private String datasetDesc;

    @Schema(description = "数据集下分类数量")
    private Long classifyNum;

    @Schema(description = "数据集下实体图片数量")
    private Long entityNum;

    @Schema(description = "创建用户")
    private String createUser;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "数据集下分类")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ClassifyInDatasetVO> classifies;
}