package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.model.auth.domain.PrivilegeUrl;


public interface PrivilegeUrlMapper {
	PrivilegeUrl selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(PrivilegeUrl privilegeUrl);

    int updateByIdSelective(PrivilegeUrl privilegeUrl);

}