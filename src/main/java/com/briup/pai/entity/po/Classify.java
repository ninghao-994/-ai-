package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("d_classify")
@Schema(description = "分类PO")
public class Classify implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "数据集ID")
    @TableField(value = "dataset_id")
    private Integer datasetId;

    @Schema(description = "数据集名称")
    @TableField(value = "classify_name")
    private String classifyName;

    @Schema(description = "是否删除（1删除 0未删除）")
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;
}