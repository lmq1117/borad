package com.sam;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sam.dao.UserMapper;
import com.sam.entity.User;
import com.sam.service.UserService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class BoardApplicationTests {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void insertTen(){
        Integer lastUserId = userService.getLastUserId();

        List<User> users = new ArrayList<>();
        int[] genders = {1,2};
        String[] registerModes = {"","wexin","alipay"};
        for (int i = lastUserId+1; i < lastUserId + 11; i++) {
            int index = (int)Math.random()*genders.length;
            int indexRegisterMode = (int)Math.random()*registerModes.length;
            User u = new User();
            u.setName("javaboy:"+i);
            //u.setId(i);
            //u.setGender(genders[index]);
            u.setGender(1);
            u.setAge(150);
            u.setTelephone("13526532135");
            u.setRegisterMode("wexin");
            if(u.getRegisterMode().length() > 0){
                u.setThirdPartyId("wexin"+i);
            }

            userService.insert(u);
            users.add(u);

        }
    }




    @Test
    void insert(){
        User u = new User();
        u.setName("javaboy:"+2);

        u.setGender(1);
        u.setAge(150);
        u.setTelephone("13526532135");
        u.setRegisterMode("wexin");
        if(u.getRegisterMode().length() > 0){
            u.setThirdPartyId("wexin"+2);
        }
        int insert = userMapper.insert(u);
        System.out.println(insert);
        System.out.println(u);
    }

    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","刘");
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
