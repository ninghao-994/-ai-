package com.briup.pai.entity.dto;

import com.briup.pai.common.validator.ValidatorGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "数据字典保存DTO")
public class DictionarySaveDTO {

    @Null(message = "数据字典编号必须为空", groups = ValidatorGroups.insert.class)
    @NotNull(message = "数据字典编号不能为空", groups = ValidatorGroups.update.class)
    @Schema(description = "数据字典ID")
    private Integer dictId;

    @NotNull(message = "数据字典父类编号不能为空", groups = ValidatorGroups.insert.class)
    @Null(message = "数据字典父类编号必须为空", groups = ValidatorGroups.update.class)
    @Schema(description = "数据字典父类ID")
    private Integer parentId;

    @NotBlank(message = "数据字典编码不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "数据字典编码")
    private String dictCode;

    @NotBlank(message = "数据字典值不能为空", groups = {ValidatorGroups.insert.class, ValidatorGroups.update.class})
    @Schema(description = "数据字典值")
    private String dictValue;
}