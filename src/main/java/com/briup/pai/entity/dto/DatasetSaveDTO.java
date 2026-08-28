package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "数据集保存DTO")
public class DatasetSaveDTO {

    @Null(message = "数据集ID必须为空", groups = ValidatorGroups.insert.class)
    @NotNull(message = "数据集ID不能为空", groups = ValidatorGroups.update.class)
    @Schema(description = "数据集ID")
    private Integer datasetId;

    @NotBlank(message = "数据集名称不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "数据集名称")
    private String datasetName;

    @NotNull(message = "数据集类型不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "数据集类型")
    private Integer datasetType;

    @NotNull(message = "数据集用途不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "数据集用途")
    private Integer datasetUsage;

    @Schema(description = "数据集描述")
    private String datasetDesc;
}