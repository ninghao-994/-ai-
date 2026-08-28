package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.DatasetMapper;
import com.briup.pai.entity.dto.DatasetSaveDTO;
import com.briup.pai.entity.po.Dataset;
import com.briup.pai.entity.vo.DatasetDetailVO;
import com.briup.pai.entity.vo.DatasetEchoVO;
import com.briup.pai.entity.vo.DatasetPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IDatasetService;
import org.springframework.stereotype.Service;

@Service
public class DatasetServiceImpl extends ServiceImpl<DatasetMapper, Dataset> implements IDatasetService {

    @Override
    public PageVO<DatasetPageVO> getDatasetByPageAndCondition(Long pageNum, Long pageSize, String datasetName, Integer datasetType) {
        return null;
    }

    @Override
    public DatasetEchoVO addOrModifyDataset(DatasetSaveDTO dto) {
        return null;
    }

    @Override
    public DatasetEchoVO modifyDatasetFeedback(Integer datasetId) {
        return null;
    }

    @Override
    public void removeDatasetById(Integer datasetId) {

    }

    @Override
    public DatasetDetailVO getDatasetDetail(Integer datasetId) {
        return null;
    }
}