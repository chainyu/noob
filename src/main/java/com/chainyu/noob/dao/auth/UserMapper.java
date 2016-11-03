package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.model.auth.domain.User;

public interface UserMapper {
    User selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(User user);

    int updateByIdSelective(User user);

}