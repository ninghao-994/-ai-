package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.ModelConfigMapper;
import com.briup.pai.entity.po.ModelConfig;
import com.briup.pai.service.IModelConfigService;
import org.springframework.stereotype.Service;

@Service
public class ModelConfigServiceImpl extends ServiceImpl<ModelConfigMapper, ModelConfig> implements IModelConfigService {

}
