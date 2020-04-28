package com.sam.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sam.entity.UserPassword;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserPasswordMapper extends BaseMapper<UserPassword> {
    @Select("select * from user_password ${ew.customSqlSegment}")
    UserPassword getUserPasswordByUserId(@Param(Constants.WRAPPER) Wrapper<UserPassword> wrapper);
}
