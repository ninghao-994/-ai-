package com.briup.pai.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "上传校验VO")
public class UploadVerifyFileVO {

    @Schema(description = "是否已完成上传")
    private Boolean uploaded;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "已经上传的分片")
    private List<Integer> uploadedChunks;
}