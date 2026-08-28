package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("m_training_label")
@Schema(description = "训练结果")
public class TrainingLabel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "训练ID")
    @TableField(value = "training_id")
    private Integer trainingId;

    @Schema(description = "标签名称")
    @TableField(value = "label_name")
    private String labelName;

    @Schema(description = "F1Score指数")
    @TableField(value = "F1Score")
    private Double f1Score;

    @Schema(description = "GScore指数")
    @TableField(value = "GScore")
    private Double gScore;

    @Schema(description = "精确率")
    @TableField(value = "precision_rate")
    private Double precisionRate;

    @Schema(description = "召回率")
    @TableField(value = "recall_rate")
    private Double recallRate;
}