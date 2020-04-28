package com.sam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sam.dao.UserMapper;
import com.sam.dao.UserPasswordMapper;
import com.sam.entity.User;
import com.sam.entity.UserPassword;
import com.sam.service.UserService;
import com.sam.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Resource
    UserPasswordMapper userPasswordMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //调用mapper获取到对应id的dataObject
        User user = userMapper.selectById(id);
        if(user == null) {
            return null;
        }
        QueryWrapper<UserPassword> userPasswordQueryWrapper = new QueryWrapper<>();
        userPasswordQueryWrapper.lambda().eq(UserPassword::getUserId,id);
        UserPassword userPassword = (UserPassword) userPasswordMapper.selectOne(userPasswordQueryWrapper);
        return convertFromUserEntity(user,userPassword);
    }

    private UserModel convertFromUserEntity(User user, UserPassword userPassword) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        if (userPassword != null) {
            userModel.setEncryptPassword(userPassword.getEncryptPassword());
        }
        return userModel;
    }
}
