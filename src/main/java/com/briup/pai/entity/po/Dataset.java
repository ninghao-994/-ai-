package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("d_dataset")
@Schema(description = "数据集PO")
public class Dataset implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "数据集名称")
    @TableField(value = "dataset_name")
    private String datasetName;

    @Schema(description = "数据集类型")
    @TableField(value = "dataset_type")
    private Integer datasetType;

    @Schema(description = "数据集详情")
    @TableField(value = "dataset_desc")
    private String datasetDesc;

    @Schema(description = "数据集状态（0初始化 1已上传）")
    @TableField(value = "dataset_status")
    private Integer datasetStatus;

    @Schema(description = "数据集用途（0初始化训练 1优化训练 2评估）")
    @TableField(value = "dataset_usage")
    private Integer datasetUsage;

    @Schema(description = "创建用户")
    @TableField(value = "create_by")
    private Integer createBy;

    @Schema(description = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @Schema(description = "是否删除（1删除 0未删除）")
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;
}