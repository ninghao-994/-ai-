package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.LogMapper;
import com.briup.pai.entity.dto.LogQueryDTO;
import com.briup.pai.entity.po.Log;
import com.briup.pai.entity.vo.LogPageVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.ILogService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Override
    public PageVO<LogPageVO> getLogByPageAndCondition(Long pageNum, Long pageSize, LogQueryDTO logQueryDTO) {
        return null;
    }

    @Override
    public void exportExcel(LogQueryDTO logQueryDTO, HttpServletResponse response) {

    }
}