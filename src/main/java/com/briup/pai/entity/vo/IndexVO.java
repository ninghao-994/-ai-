package com.briup.pai.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "首页数据VO")
public class IndexVO {

    @Schema(description = "模型数量展示VO")
    private List<ModelCountVO> modelCounts;

    @Schema(description = "本周模型训练数量VO")
    private List<ModelChartVO> modelCharts;
}
