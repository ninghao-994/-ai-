package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("o_operator")
@Schema(description = "算子PO")
public class Operator implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "算子名称")
    @TableField(value = "operator_name")
    private String operatorName;

    @Schema(description = "算子类型")
    @TableField(value = "operator_type")
    private Integer operatorType;

    @Schema(description = "算子路径")
    @TableField(value = "operator_url")
    private String operatorUrl;

    @Schema(description = "算子分类（1网络结构 2优化器 3损失函数）")
    @TableField(value = "operator_category")
    private Integer operatorCategory;

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