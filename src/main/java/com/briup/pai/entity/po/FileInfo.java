package com.briup.pai.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("d_file_info")
@Schema(description = "文件PO")
public class FileInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "文件MD5值")
    @TableField(value = "file_hash")
    private String fileHash;

    @Schema(description = "文件名称")
    @TableField(value = "file_name")
    private String fileName;

    @Schema(description = "文件大小（字节）")
    @TableField(value = "file_size")
    private Long fileSize;

    @Schema(description = "分片大小")
    @TableField(value = "chunk_size")
    private Long chunkSize;

    @Schema(description = "分片数量")
    @TableField(value = "chunk_num")
    private Long chunkNum;

    @Schema(description = "文件存储路径")
    @TableField(value = "file_path")
    private String filePath;

    @Schema(description = "上传状态（0初始化 1上传中 2已暂停 3完成）")
    @TableField(value = "upload_status")
    private Integer uploadStatus;
}