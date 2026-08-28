package com.briup.pai.service;

import com.briup.pai.entity.vo.IndexVO;

public interface IIndexService {

    // 获取首页数据大屏
    IndexVO getModelChartData();
}