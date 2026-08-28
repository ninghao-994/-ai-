package com.briup.pai.service;

import com.briup.pai.entity.dto.UploadChunkDTO;
import com.briup.pai.entity.dto.UploadVerifyFileDTO;
import com.briup.pai.entity.vo.UploadVerifyFileVO;

public interface IUploadService {

    // 修改数据集状态
    void modifyDatasetStatus(Integer datasetId, Integer status);

    // 校验文件是否上传
    UploadVerifyFileVO verifyFile(UploadVerifyFileDTO dto);

    // 上传分片
    void uploadChunk(UploadChunkDTO dto);

    // 修改上传状态
    void modifyUploadStatus(String fileHash, Integer uploadStatus);

    // 合并分片
    void mergeChunks(String fileHash);

    // 解压数据集zip文件
    void unzipDataset(Integer datasetId, String fileHash);

    // 解压分类zip文件
    void unzipClassify(Integer datasetId, Integer classifyId, String fileHash);
}