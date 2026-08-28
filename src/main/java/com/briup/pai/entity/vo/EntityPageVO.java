package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "实体图片分页VO")
public class EntityPageVO {

    @Schema(description = "实体图片ID")
    private Integer entityId;

    @Schema(description = "实体图片路径")
    private String entityUrl;
}