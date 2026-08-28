package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.TrainingDatasetMapper;
import com.briup.pai.entity.po.TrainingDataset;
import com.briup.pai.service.ITrainingDatasetService;
import org.springframework.stereotype.Service;

@Service
public class TrainingDatasetServiceImpl extends ServiceImpl<TrainingDatasetMapper, TrainingDataset> implements ITrainingDatasetService {

}