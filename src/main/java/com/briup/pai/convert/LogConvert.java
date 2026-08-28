package com.briup.pai.convert;

import com.briup.pai.common.enums.LogTypeEnum;
import com.briup.pai.common.enums.RequestStatusEnum;
import com.briup.pai.common.enums.ResultCodeEnum;
import com.briup.pai.common.exception.CustomException;
import com.briup.pai.entity.dto.LogExportDTO;
import com.briup.pai.entity.po.Log;
import com.briup.pai.entity.vo.LogPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogConvert {

    // Log -> LogPageVO
    @Mapping(target = "type", qualifiedByName = "getLogType")
    @Mapping(target = "isSuccess", qualifiedByName = "getRequestStatus")
    LogPageVO po2LogQueryVO(Log log);

    // List<Log> -> List<LogPageVO>
    List<LogPageVO> po2LogQueryVOList(List<Log> logs);

    // Log -> LogExportDTO
    @Mapping(target = "type", qualifiedByName = "getLogType")
    @Mapping(target = "isSuccess", qualifiedByName = "getRequestStatus")
    LogExportDTO po2LogExportDTO(Log log);

    // List<Log> -> List<LogExportDTO>
    List<LogExportDTO> po2LogExportDTOList(List<Log> logList);

    @Named("getLogType")
    default String getLogType(Integer type) {
        if (LogTypeEnum.LOGIN.getType().equals(type)) {
            return LogTypeEnum.LOGIN.getDesc();
        } else if (LogTypeEnum.OPERATION.getType().equals(type)) {
            return LogTypeEnum.OPERATION.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }

    @Named("getRequestStatus")
    default String getRequestStatus(Integer status) {
        if (RequestStatusEnum.SUCCESS.getStatus().equals(status)) {
            return RequestStatusEnum.SUCCESS.getDesc();
        } else if (RequestStatusEnum.FAIL.getStatus().equals(status)) {
            return RequestStatusEnum.FAIL.getDesc();
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_IS_ERROR);
        }
    }
}