package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "首页模型数量VO")
@AllArgsConstructor
@NoArgsConstructor
public class ModelCountVO {

    @Schema(description = "展示标签索引，5模型总数 0未训练 1训练中 2优化中 3评估中 4已完成")
    private Integer index;

    @Schema(description = "模型数量")
    private Long modelCount;
}
