package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {



    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void save(){
        User user = new User();
        user.setAge(15);
        user.setName("xx");
        user.setEmail("xxx");

        User user1 = new User();
        user1.setAge(15);
        user1.setName("yyy");
        user1.setEmail("xxx");

        List<User> list =new ArrayList<>();
        list.add(user);
        list.add(user1);

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);

    }


    @Test
    public void saveOrUpdate(){
        //如果id有值，就修改，没有值就插入
        User user = new User();
        user.setId(4l);
        user.setAge(15);
        user.setName("xx");
        user.setEmail("xxx");
        boolean b = userService.saveOrUpdate(user);
        System.out.println("b = " + b);
    }

    @Test
    public void remove(){
        boolean b = userService.removeById(5l);
        System.out.println("b = " + b);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(4l);
        user.setAge(15);
        user.setName("yyyyy");
        user.setEmail("yyyyy");
        boolean b = userService.updateById(user);
        System.out.println("b = " + b);
    }

    @Test
    public void getById(){
        User byId = userService.getById(1l);
        System.out.println("byId = " + byId);
    }

    //使用分页查询
    @Test
    public void testPageQuery(){
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }
}
