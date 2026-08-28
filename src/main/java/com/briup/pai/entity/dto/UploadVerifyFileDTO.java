package com.briup.pai.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "上传校验文件DTO")
public class UploadVerifyFileDTO {

    @NotBlank(message = "文件MD5值不能为空")
    @Schema(description = "文件MD5值")
    private String fileHash;

    @NotBlank(message = "文件名称不能为空")
    @Schema(description = "文件名称")
    private String fileName;

    @NotNull(message = "分片大小不能为空")
    private Long chunkSize;

    @NotNull(message = "文件大小不能为空")
    @Schema(description = "文件大小")
    private Long fileSize;
}