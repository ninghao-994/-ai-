package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "模型训练DTO")
public class ModelOperationDTO {

    @NotNull(message = "模型Id不能为空", groups = {ValidatorGroups.train.class, ValidatorGroups.evaluate.class})
    @Schema(description = "模型Id")
    private Integer modelId;

    @NotNull(message = "操作类型不能为空", groups = {ValidatorGroups.train.class, ValidatorGroups.evaluate.class})
    @Schema(description = "操作类型")
    private Integer operationType;

    @NotEmpty(message = "数据集Id列表不能为空", groups = {ValidatorGroups.train.class, ValidatorGroups.evaluate.class})
    @Schema(description = "训练参数：数据集Id")
    private List<Integer> datasetIds;

    @NotBlank(message = "分辨率不能为空", groups = {ValidatorGroups.train.class})
    @Schema(description = "训练参数：分辨率")
    private String resolution;

    @NotBlank(message = "迭代次数不能为空", groups = {ValidatorGroups.train.class})
    @Schema(description = "训练参数：迭代次数")
    private String iterateTimes;

    @NotBlank(message = "网络结构不能为空", groups = {ValidatorGroups.train.class})
    @Schema(description = "训练参数：网络结构")
    private String networkStructure;

    @NotBlank(message = "优化器不能为空", groups = {ValidatorGroups.train.class})
    @Schema(description = "训练参数：优化器")
    private String optimizer;

    @NotBlank(message = "损失值不能为空", groups = {ValidatorGroups.train.class})
    @Schema(description = "训练参数：损失函数")
    private String lossValue;
}