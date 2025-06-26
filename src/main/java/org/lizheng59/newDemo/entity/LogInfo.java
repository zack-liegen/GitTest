package org.lizheng59.newDemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
@Data
@TableName("log_info")
public class LogInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField
    private String url;
    @TableField
    private Timestamp timestamp;
    @TableField
    private String ip;
}
