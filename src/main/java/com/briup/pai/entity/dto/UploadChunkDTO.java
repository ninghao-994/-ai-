package com.briup.pai.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Schema(description = "分片上传DTO")
public class UploadChunkDTO {

    @NotNull(message = "分片文件不能为空")
    @Schema(description = "分片文件")
    @JSONField(serialize = false)
    private MultipartFile file;

    @NotBlank(message = "文件MD5不能为空")
    @Schema(description = "文件MD5")
    private String fileHash;

    @NotNull(message = "分片索引不能为空")
    @Schema(description = "分片索引")
    private Integer chunkIndex;
}