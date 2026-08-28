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
@TableName("m_evaluate_error")
@Schema(description = "评估错误PO")
public class EvaluateError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "评估ID")
    @TableField(value = "evaluate_id")
    private Integer evaluateId;

    @Schema(description = "图片地址")
    @TableField(value = "pic_address")
    private String picAddress;

    @Schema(description = "图片原始标签")
    @TableField(value = "old_label")
    private String oldLabel;

    @Schema(description = "图片识别标签")
    @TableField(value = "new_label")
    private String newLabel;
}