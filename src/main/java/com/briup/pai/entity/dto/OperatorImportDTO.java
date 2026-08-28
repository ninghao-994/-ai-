package com.briup.pai.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "算子导入DTO")
public class OperatorImportDTO {

    @ExcelProperty(value = "算子名称", index = 1)
    private String operatorName;

    @ExcelProperty(value = "算子分类", index = 2)
    private String operatorCategory;

    @ExcelProperty(value = "算子类型", index = 3)
    private String operatorType;

    @ExcelProperty(value = "程序路径", index = 4)
    private String operatorUrl;
}