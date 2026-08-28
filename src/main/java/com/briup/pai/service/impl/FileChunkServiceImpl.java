package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.FileChunkMapper;
import com.briup.pai.entity.po.FileChunk;
import com.briup.pai.service.IFileChunkService;
import org.springframework.stereotype.Service;

@Service
public class FileChunkServiceImpl extends ServiceImpl<FileChunkMapper, FileChunk> implements IFileChunkService {

}