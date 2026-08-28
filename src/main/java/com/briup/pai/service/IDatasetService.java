package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.DatasetSaveDTO;
import com.briup.pai.entity.po.Dataset;
import com.briup.pai.entity.vo.DatasetDetailVO;
import com.briup.pai.entity.vo.DatasetEchoVO;
import com.briup.pai.entity.vo.DatasetPageVO;
import com.briup.pai.entity.vo.PageVO;

public interface IDatasetService extends IService<Dataset> {

    // 条件分页查询数据集信息
    PageVO<DatasetPageVO> getDatasetByPageAndCondition(Long pageNum, Long pageSize, String datasetName, Integer datasetType);

    // 添加或者修改数据集
    DatasetEchoVO addOrModifyDataset(DatasetSaveDTO dto);

    // 修改数据回显
    DatasetEchoVO modifyDatasetFeedback(Integer datasetId);

    // 根据ID删除数据集
    void removeDatasetById(Integer datasetId);

    // 根据数据集ID查询数据集详情信息
    DatasetDetailVO getDatasetDetail(Integer datasetId);
}