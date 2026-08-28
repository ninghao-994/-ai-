package com.briup.pai.convert;

import com.briup.pai.entity.dto.UploadVerifyFileDTO;
import com.briup.pai.entity.po.FileInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileInfoConvert {

    // UploadVerifyFileDTO -> FileInfo
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "chunkSize", ignore = true)
    @Mapping(target = "chunkNum", ignore = true)
    @Mapping(target = "filePath", ignore = true)
    @Mapping(target = "uploadStatus", ignore = true)
    FileInfo uploadVerifyFileDTO2Po(UploadVerifyFileDTO dto);
}