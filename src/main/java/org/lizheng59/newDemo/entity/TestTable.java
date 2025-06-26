package org.lizheng59.newDemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_table")
public class TestTable {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField
    private String name;
}
