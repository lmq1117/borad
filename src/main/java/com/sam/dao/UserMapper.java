package com.sam.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sam.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    //xml方式自定义查询
    List<User> getUserList();

    //xml方式自定义查询 带mp条件构造器
    List<User> getCustomUserListXml(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    //注解方式自定义查询
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> getCustomUserList(@Param(Constants.WRAPPER)Wrapper<User> wrapper);
}
