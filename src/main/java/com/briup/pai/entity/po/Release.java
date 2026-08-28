package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("m_release")
@Schema(description = "发布PO")
public class Release implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "模型ID")
    @TableField(value = "model_id")
    private Integer modelId;

    @Schema(description = "模型访问地址")
    @TableField(value = "model_url")
    private String modelUrl;

    @Schema(description = "创建用户")
    @TableField(value = "create_by")
    private Integer createBy;

    @Schema(description = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;
}