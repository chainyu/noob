package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.model.auth.domain.Privilege;


public interface PrivilegeMapper {
    Privilege selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(Privilege privilege);

    int updateByIdSelective(Privilege privilege);

}