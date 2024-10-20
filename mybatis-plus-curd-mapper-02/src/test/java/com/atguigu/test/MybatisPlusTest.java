package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void insert(){
        User user =new User();
        user.setId(10L);
        user.setAge(15);
        user.setName("zhangsan");
        user.setEmail("xxxx");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void delete(){
        int i = userMapper.deleteById(10L);
        System.out.println("i = " + i);
    }

    @Test
    public void update(){
        User user =new User();
        // 对于为null的值，数据库不会更改，只会修改有值的字段 ==> 因此某些字段应该是Integer类型，不能是int类型
        // 因为int类型会自动有默认值0，而不是null
        user.setAge(20);
        int update = userMapper.update(user, null);
        System.out.println("update = " + update);
    }
}
