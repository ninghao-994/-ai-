package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.TrainingLabelMapper;
import com.briup.pai.entity.po.TrainingLabel;
import com.briup.pai.service.ITrainingLabelService;
import org.springframework.stereotype.Service;

@Service
public class TrainingLabelServiceImpl extends ServiceImpl<TrainingLabelMapper, TrainingLabel> implements ITrainingLabelService {

}