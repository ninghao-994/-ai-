package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "模型保存DTO")
public class ModelSaveDTO {

    @NotNull(message = "模型ID不能为空", groups = {ValidatorGroups.update.class})
    @Null(message = "模型ID不能传值", groups = {ValidatorGroups.insert.class})
    @Schema(description = "模型ID")
    private Integer modelId;

    @NotBlank(message = "模型名称不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "模型名称")
    private String modelName;

    @NotNull(message = "模型类型不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "模型类型")
    private Integer modelType;

    @Schema(description = "模型描述")
    private String modelDesc;
}