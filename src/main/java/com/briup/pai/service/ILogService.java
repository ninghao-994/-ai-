package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.LogQueryDTO;
import com.briup.pai.entity.po.Log;
import com.briup.pai.entity.vo.LogPageVO;
import com.briup.pai.entity.vo.PageVO;
import jakarta.servlet.http.HttpServletResponse;

public interface ILogService extends IService<Log> {

    // 条件分页查询日志信息
    PageVO<LogPageVO> getLogByPageAndCondition(Long pageNum, Long pageSize, LogQueryDTO logQueryDTO);

    // 导出日志
    void exportExcel(LogQueryDTO logQueryDTO, HttpServletResponse response);
}