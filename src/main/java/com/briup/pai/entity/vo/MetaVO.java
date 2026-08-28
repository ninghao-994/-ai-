package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "路由元数据VO")
public class MetaVO {

    @Schema(description = "标题")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @Schema(description = "图标")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String icon;
}
