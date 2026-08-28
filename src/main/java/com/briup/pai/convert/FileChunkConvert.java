package com.briup.pai.convert;

import com.briup.pai.entity.dto.UploadChunkDTO;
import com.briup.pai.entity.po.FileChunk;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileChunkConvert {

    // UploadChunkDTO -> FileChunk
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "chunkSize", ignore = true)
    @Mapping(target = "chunkPath", ignore = true)
    FileChunk uploadChunkDTO2Po(UploadChunkDTO dto);
}