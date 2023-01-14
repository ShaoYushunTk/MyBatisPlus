package org.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 名称   @TableId
 * 类型   属性注解
 * 位置   模型类中用于表示主键的属性定义上方
 * 作用   设置当前类中主键属性的生成策略
 * 相关属性 value(默认)：设置数据库表主键名称
 *        type:设置主键属性的生成策略，值查照IdType的枚举值
 */
@Data
@TableName("tbl_user")
public class User {
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)
    private String password;//设置value属性解决表字段名称和实体类属性名称不同的问题，select=false表示默认不查询该字段
    private Integer age;
    private String tel;

    @TableField(exist = false)
    private Integer online;//此属性在数据库表中不存在

    //逻辑删除字段 标记当前字段是否被删除
    //未删除value = 0 删除del val = 1
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @Version
    private Integer version; //乐观锁

}
