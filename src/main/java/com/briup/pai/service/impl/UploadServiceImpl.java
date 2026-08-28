package com.briup.pai.service.impl;

import com.briup.pai.entity.dto.UploadChunkDTO;
import com.briup.pai.entity.dto.UploadVerifyFileDTO;
import com.briup.pai.entity.vo.UploadVerifyFileVO;
import com.briup.pai.service.IUploadService;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements IUploadService {

    @Override
    public void modifyDatasetStatus(Integer datasetId, Integer status) {

    }

    @Override
    public UploadVerifyFileVO verifyFile(UploadVerifyFileDTO dto) {
        return null;
    }

    @Override
    public void uploadChunk(UploadChunkDTO dto) {

    }

    @Override
    public void modifyUploadStatus(String fileHash, Integer uploadStatus) {

    }

    @Override
    public void mergeChunks(String fileHash) {

    }

    @Override
    public void unzipDataset(Integer datasetId, String fileHash) {

    }

    @Override
    public void unzipClassify(Integer datasetId, Integer classifyId, String fileHash) {

    }
}