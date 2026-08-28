package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("sys_dictionary")
@Schema(description = "数据字典PO")
public class Dictionary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "父字典ID")
    @TableField(value = "parent_id")
    private Integer parentId;

    @Schema(description = "字典编码")
    @TableField(value = "dict_code")
    private String dictCode;

    @Schema(description = "字典值")
    @TableField(value = "dict_value")
    private String dictValue;

    @Schema(description = "是否删除（1删除 0未删除）")
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;
}