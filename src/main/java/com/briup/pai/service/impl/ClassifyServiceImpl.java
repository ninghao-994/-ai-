package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.ClassifyMapper;
import com.briup.pai.entity.dto.ClassifySaveDTO;
import com.briup.pai.entity.po.Classify;
import com.briup.pai.entity.vo.ClassifyEchoVO;
import com.briup.pai.entity.vo.ClassifyInDatasetVO;
import com.briup.pai.service.IClassifyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {

    @Override
    public List<ClassifyInDatasetVO> getClassifiesByDatasetId(Integer datasetId) {
        return List.of();
    }

    @Override
    public ClassifyEchoVO addOrModifyClassify(ClassifySaveDTO dto) {
        return null;
    }

    @Override
    public void removeClassifyById(Integer datasetId, Integer classifyId) {

    }

    @Override
    public ClassifyEchoVO getClassifyById(Integer classifyId) {
        return null;
    }
}