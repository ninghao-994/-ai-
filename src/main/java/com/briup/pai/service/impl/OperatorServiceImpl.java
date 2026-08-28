package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.OperatorMapper;
import com.briup.pai.entity.dto.OperatorUpdateDTO;
import com.briup.pai.entity.po.Operator;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.OperatorEchoVO;
import com.briup.pai.entity.vo.OperatorPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IOperatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements IOperatorService {

    @Override
    public void importOperator(MultipartFile file) {

    }

    @Override
    public PageVO<OperatorPageVO> getOperatorByPageAndCondition(Long pageNum, Long pageSize, Integer operatorType, Integer operatorCategory) {
        return null;
    }

    @Override
    public OperatorEchoVO getOperatorById(Integer operatorId) {
        return null;
    }

    @Override
    public OperatorEchoVO modifyOperatorById(OperatorUpdateDTO dto) {
        return null;
    }

    @Override
    public void removeOperatorById(Integer operatorId) {

    }

    @Override
    public void removeOperatorByIds(List<Integer> ids) {

    }

    @Override
    public Map<Integer, List<DropDownVO>> getOperatorDropDownList() {
        return Map.of();
    }
}