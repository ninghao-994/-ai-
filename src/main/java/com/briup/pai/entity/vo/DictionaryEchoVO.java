package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "数据字典数据回显VO")
public class DictionaryEchoVO {

    @Schema(description = "数据字典编号")
    private Integer dictId;

    @Schema(description = "数据字典编码")
    private String dictCode;

    @Schema(description = "数据字典值")
    private String dictValue;
}