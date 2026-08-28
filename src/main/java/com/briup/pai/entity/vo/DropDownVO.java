package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "数据字典下拉框VO")
public class DropDownVO {

    @Schema(description = "下拉框提交的数据")
    private String key;

    @Schema(description = "下拉框展示的数据")
    private String value;
}