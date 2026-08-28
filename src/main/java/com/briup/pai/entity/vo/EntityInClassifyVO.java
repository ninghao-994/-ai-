package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分类下实体VO")
public class EntityInClassifyVO {

    @Schema(description = "实体ID")
    private Integer entityId;

    @Schema(description = "实体图片地址")
    private String entityUrl;
}
