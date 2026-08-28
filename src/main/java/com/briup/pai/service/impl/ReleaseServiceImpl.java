package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.ReleaseMapper;
import com.briup.pai.entity.po.Release;
import com.briup.pai.service.IReleaseService;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceImpl extends ServiceImpl<ReleaseMapper, Release> implements IReleaseService {

}