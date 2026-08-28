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
@TableName("m_model_config")
@Schema(description = "模型配置PO")
public class ModelConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "模型ID")
    @TableField(value = "model_id")
    private Integer modelId;

    @Schema(description = "分辨率")
    @TableField(value = "resolution")
    private String resolution;

    @Schema(description = "迭代次数")
    @TableField(value = "iterate_times")
    private String iterateTimes;

    @Schema(description = "网络结构")
    @TableField(value = "network_structure")
    private String networkStructure;

    @Schema(description = "优化器")
    @TableField(value = "optimizer")
    private String optimizer;

    @Schema(description = "损失值")
    @TableField(value = "loss_value")
    private String lossValue;
}
