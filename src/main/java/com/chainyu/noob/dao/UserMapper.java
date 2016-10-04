package com.chainyu.noob.dao;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.model.auth.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(@Param("id")Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id")Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}