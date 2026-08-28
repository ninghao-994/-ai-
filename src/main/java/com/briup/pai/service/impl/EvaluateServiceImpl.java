package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.EvaluateMapper;
import com.briup.pai.entity.po.Evaluate;
import com.briup.pai.service.IEvaluateService;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements IEvaluateService {

}