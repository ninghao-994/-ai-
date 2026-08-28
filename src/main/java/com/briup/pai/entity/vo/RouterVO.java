package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "路由VO")
public class RouterVO {

    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "路由组件")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String component;

    @Schema(description = "是否隐藏")
    private Boolean hidden;

    @Schema(description = "meta信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MetaVO meta;

    @Schema(description = "子路由")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RouterVO> children;
}