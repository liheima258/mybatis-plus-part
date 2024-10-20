package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user") //如果表名和实体类名相同（忽略大小写）可以省略该注解
public class User {
    @TableId(value="id",type= IdType.AUTO)
    /**
     * 全局配置
         * mybatis-plus:
         *   global-config:
         *     db-config:
         *       # 配置MyBatis-Plus操作表的默认前缀
         *       table-prefix: t_
         *       # 配置MyBatis-Plus的主键策略
         *       id-type: auto
     */
    private Long id;
    @TableField(value = "name",exist = true)
    private String name;
    private Integer age;
    private String email;
}
