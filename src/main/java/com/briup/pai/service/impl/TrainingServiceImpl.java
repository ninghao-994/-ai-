package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.TrainingMapper;
import com.briup.pai.entity.po.Training;
import com.briup.pai.service.ITrainingService;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl extends ServiceImpl<TrainingMapper, Training> implements ITrainingService {

}