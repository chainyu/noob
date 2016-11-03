package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.model.auth.domain.UserRole;

public interface UserRoleMapper {
    UserRole selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(UserRole userRole);

    int updateByIdSelective(UserRole userRole);

}