package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.ClassifySaveDTO;
import com.briup.pai.entity.po.Classify;
import com.briup.pai.entity.vo.ClassifyEchoVO;
import com.briup.pai.entity.vo.ClassifyInDatasetVO;

import java.util.List;

public interface IClassifyService extends IService<Classify> {

    // 根据数据集编号获取分类信息
    List<ClassifyInDatasetVO> getClassifiesByDatasetId(Integer datasetId);

    // 添加或者修改分类
    ClassifyEchoVO addOrModifyClassify(ClassifySaveDTO dto);

    // 根据分类Id删除分类
    void removeClassifyById(Integer datasetId, Integer classifyId);

    // 根据分类Id查询分类信息
    ClassifyEchoVO getClassifyById(Integer classifyId);
}