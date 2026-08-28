package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.entity.dto.UploadChunkDTO;
import com.briup.pai.entity.dto.UploadVerifyFileDTO;
import com.briup.pai.service.IUploadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/upload")
@Tag(name = "上传控制器")
public class UploadController {

    @Resource
    private IUploadService uploadService;

    @PutMapping("/dataset/{datasetId}/{status}")
    @Operation(summary = "修改数据集状态")
    public Result modifyDatasetStatus(
            @PathVariable(value = "datasetId") Integer datasetId,
            @PathVariable(value = "status") Integer status) {
        uploadService.modifyDatasetStatus(datasetId, status);
        return Result.success();
    }

    @PostMapping("/verifyFile")
    @Operation(summary = "校验文件是否上传")
    public Result verifyFile(
            @RequestBody @Valid UploadVerifyFileDTO dto) {
        return Result.success(uploadService.verifyFile(dto));
    }

    @PostMapping("/chunk")
    @Operation(summary = "上传分片")
    public Result uploadChunk(
            @Valid UploadChunkDTO dto) {
        uploadService.uploadChunk(dto);
        return Result.success();
    }

    @PutMapping("/fileInfo/{fileHash}/{uploadStatus}")
    @Operation(summary = "修改文件状态")
    public Result modifyUploadStatus(
            @PathVariable(value = "fileHash") String fileHash,
            @PathVariable(value = "uploadStatus") Integer uploadStatus) {
        uploadService.modifyUploadStatus(fileHash, uploadStatus);
        return Result.success();
    }

    @PostMapping("/merge/{fileHash}")
    @Operation(summary = "合并分片")
    public Result mergeChunks(
            @PathVariable(value = "fileHash") String fileHash) {
        uploadService.mergeChunks(fileHash);
        return Result.success();
    }

    @PostMapping("/unzip/dataset/{datasetId}/{fileHash}")
    @Operation(summary = "归档数据集")
    public Result unzipDataset(
            @PathVariable(value = "datasetId") Integer datasetId,
            @PathVariable(value = "fileHash") String fileHash) {
        uploadService.unzipDataset(datasetId, fileHash);
        return Result.success();
    }

    @PostMapping("/unzip/classify/{datasetId}/{classifyId}/{fileHash}")
    @Operation(summary = "归档分类")
    public Result unzipClassify(
            @PathVariable(value = "datasetId") Integer datasetId,
            @PathVariable(value = "classifyId") Integer classifyId,
            @PathVariable(value = "fileHash") String fileHash) {
        uploadService.unzipClassify(datasetId, classifyId, fileHash);
        return Result.success();
    }
}