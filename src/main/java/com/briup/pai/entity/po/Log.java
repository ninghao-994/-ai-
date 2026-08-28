package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_log")
@Schema(description = "日志PO")
public class Log implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "日志类型（1操作日志 2登录日志）")
    @TableField(value = "type")
    private Integer type;

    @Schema(description = "请求URI")
    @TableField(value = "request_uri")
    private String requestUri;

    @Schema(description = "请求方式")
    @TableField(value = "request_method")
    private String requestMethod;

    @Schema(description = "请求IP")
    @TableField(value = "request_ip")
    private String requestIp;

    @Schema(description = "请求参数")
    @TableField(value = "request_params")
    private String requestParams;

    @Schema(description = "请求方法名称")
    @TableField(value = "method_name")
    private String methodName;

    @Schema(description = "请求耗时（单位：ms）")
    @TableField(value = "request_time")
    private Long requestTime;

    @Schema(description = "是否成功（1失败 0成功）")
    @TableField(value = "is_success")
    private Integer isSuccess;

    @Schema(description = "响应数据")
    @TableField(value = "response_data")
    private String responseData;

    @Schema(description = "操作用户（用户名或者手机号码）")
    @TableField(value = "operate_user")
    private String operateUser;

    @Schema(description = "操作时间")
    @TableField(value = "operate_time")
    private Date operateTime;
}