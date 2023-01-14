package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_user")
public class User {
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)
    private String password;//设置value属性解决表字段名称和实体类属性名称不同的问题，select=false表示默认不查询该字段
    private Integer age;
    private String tel;

    @TableField(exist = false)
    private Integer online;//此属性在数据库表中不存在

}
