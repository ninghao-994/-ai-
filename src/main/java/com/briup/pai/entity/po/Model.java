package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("m_model")
@Schema(description = "模型PO")
public class Model implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "模型名称")
    @TableField(value = "model_name")
    private String modelName;

    @Schema(description = "模型状态（1发布 0未发布）")
    @TableField(value = "model_status")
    private Integer modelStatus;

    @Schema(description = "模型描述")
    @TableField(value = "model_desc")
    private String modelDesc;

    @Schema(description = "模型类型")
    @TableField(value = "model_type")
    private Integer modelType;

    @Schema(description = "模型最新版本")
    @TableField(value = "last_model_version")
    private Integer lastModelVersion;

    @Schema(description = "训练状态（0未训练 1训练中 2训练完成 3优化中 4优化完成）")
    @TableField(value = "training_status")
    private Integer trainingStatus;

    @Schema(description = "模型准确率")
    @TableField(value = "accuracy_rate")
    private Double accuracyRate;

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