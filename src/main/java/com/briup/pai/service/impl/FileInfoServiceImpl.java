package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.FileInfoMapper;
import com.briup.pai.entity.po.FileInfo;
import com.briup.pai.service.IFileInfoService;
import org.springframework.stereotype.Service;

@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements IFileInfoService {

}