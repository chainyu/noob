package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;
import com.chainyu.noob.model.auth.domain.RolePrivilege;


public interface RolePrivilegeMapper {
	RolePrivilege selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(RolePrivilege rolePrivilege);

    int updateByIdSelective(RolePrivilege rolePrivilege);

}