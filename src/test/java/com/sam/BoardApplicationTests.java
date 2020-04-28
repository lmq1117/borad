package com.sam;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sam.dao.UserMapper;
import com.sam.entity.User;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class BoardApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","J");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void wrapperTest() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().likeRight(User::getName,"J");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    //xml自定义查询测试
    @Test
    void xmlSelectTest() {
        userMapper.getUserList().forEach(System.out::println);
    }

    //xml自定义查询测试 用到查询构建器
//    @Test
//    void xmlSelectCustomTest() {
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.lambda().ge(User::getAge,22).likeLeft(User::getEmail,"com");
//        userMapper.getCustomUserListXml(wrapper).forEach(System.out::println);
//    }


    //注解方式自定义查询测试
    @Test
    void annotationSelectTest(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().ge(User::getAge,20);
        userMapper.getCustomUserList(wrapper).forEach(System.out::println);
    }

    //分页
    @Test
    void selectPage(){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.lambda().gt(User::getId,1);
        Page<User> page = new Page<>(4,3);
        IPage iPage = userMapper.selectPage(page,wrapper);

        System.out.println("当前页："+iPage.getCurrent());
        System.out.println("每页几条："+iPage.getSize());
        System.out.println("总页数："+iPage.getPages());
        System.out.println("总条页："+iPage.getTotal());
        iPage.getRecords().forEach(System.out::println);

    }
}
