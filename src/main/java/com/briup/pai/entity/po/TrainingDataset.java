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
@TableName("m_training_dataset")
@Schema(description = "训练数据集PO")
public class TrainingDataset implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "训练ID")
    @TableField(value = "training_id")
    private Integer trainingId;

    @Schema(description = "数据集ID")
    @TableField(value = "dataset_id")
    private Integer datasetId;
}