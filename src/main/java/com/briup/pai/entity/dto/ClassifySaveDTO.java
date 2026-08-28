package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "分类保存DTO")
public class ClassifySaveDTO {

    @Null(message = "分类编号必须为空", groups = ValidatorGroups.insert.class)
    @NotNull(message = "分类编号不能为空", groups = ValidatorGroups.update.class)
    @Schema(description = "分类ID")
    private Integer classifyId;

    @NotBlank(message = "分类名称不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "分类名称")
    private String classifyName;

    @NotNull(message = "数据集编号不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "数据集ID")
    private Integer datasetId;
}