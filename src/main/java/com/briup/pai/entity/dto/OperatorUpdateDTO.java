package com.briup.pai.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "算子保存DTO")
public class OperatorUpdateDTO {

    @Schema(description = "算子编号")
    @NotNull(message = "算子编号不能为空")
    private Integer operatorId;

    @Schema(description = "算子名称")
    @NotBlank(message = "算子名称不能为空")
    private String operatorName;

    @Schema(description = "程序路径")
    @NotBlank(message = "程序路径不能为空")
    private String operatorUrl;
}