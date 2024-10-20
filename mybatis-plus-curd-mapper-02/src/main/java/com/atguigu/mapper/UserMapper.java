package com.atguigu.mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


//继承mybatis-plus提供的基础Mapper接口，自带crud方法
public interface UserMapper extends BaseMapper<User> {

}
