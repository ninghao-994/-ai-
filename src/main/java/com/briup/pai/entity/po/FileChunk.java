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
@TableName("d_file_chunk")
@Schema(description = "文件分片PO")
public class FileChunk implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "文件MD5值")
    @TableField(value = "file_hash")
    private String fileHash;

    @Schema(description = "分片索引号")
    @TableField(value = "chunk_index")
    private Integer chunkIndex;

    @Schema(description = "分片大小（字节）")
    @TableField(value = "chunk_size")
    private Long chunkSize;

    @Schema(description = "分片存储路径")
    @TableField(value = "chunk_path")
    private String chunkPath;
}