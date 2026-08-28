package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分页查询统一响应VO对象")
public class PageVO<T> {

    @Schema(description = "数据总条数")
    private Long total;

    @Schema(description = "当前页的数据")
    private List<T> data;
}
