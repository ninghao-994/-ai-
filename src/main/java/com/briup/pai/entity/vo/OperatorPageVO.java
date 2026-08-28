package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "分页查询算子信息VO")
public class OperatorPageVO {

    @Schema(description = "算子ID")
    private Integer operatorId;

    @Schema(description = "算子名称")
    private String operatorName;

    @Schema(description = "算子类型")
    private String operatorType;

    @Schema(name = "算子路径")
    private String operatorUrl;

    @Schema(description = "分类名称")
    private String operatorCategory;

    @Schema(name = "创建用户")
    private String createUser;

    @Schema(name = "创建时间")
    private Date createTime;
}
