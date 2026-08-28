package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.OperatorUpdateDTO;
import com.briup.pai.entity.po.Operator;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.OperatorEchoVO;
import com.briup.pai.entity.vo.OperatorPageVO;
import com.briup.pai.entity.vo.PageVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IOperatorService extends IService<Operator> {

    // 导入算子信息
    void importOperator(MultipartFile file);

    // 分页查询算子信息
    PageVO<OperatorPageVO> getOperatorByPageAndCondition(Long pageNum, Long pageSize, Integer operatorType, Integer operatorCategory);

    // 根据编号查询算子信息
    OperatorEchoVO getOperatorById(Integer operatorId);

    // 修改算子信息
    OperatorEchoVO modifyOperatorById(OperatorUpdateDTO dto);

    // 根据编号删除算子信息
    void removeOperatorById(Integer operatorId);

    // 批量删除算子信息
    void removeOperatorByIds(List<Integer> ids);

    // 查询不同算子类型下拉框数据
    Map<Integer, List<DropDownVO>> getOperatorDropDownList();
}