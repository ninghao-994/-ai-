package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "数据字典分页查询VO对象")
public class DictionaryPageVO {

    @Schema(description = "数据字典编号")
    private Integer dictId;

    @Schema(description = "父编号")
    private Integer parentId;

    @Schema(description = "数据字典编码")
    private String dictCode;

    @Schema(description = "数据字典值")
    private String dictValue;

    @Schema(description = "子数据字典信息")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DictionaryPageVO> children;
}
