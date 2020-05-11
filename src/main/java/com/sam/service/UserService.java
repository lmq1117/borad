package com.sam.service;

import com.sam.entity.User;
import com.sam.service.model.UserModel;

public interface UserService {

    //通过用户id获取用户对象的方法
    UserModel getUserById(Integer id);


    //获取最新的那个用户的ID
    Integer getLastUserId();

    Integer insert(User user);
}
