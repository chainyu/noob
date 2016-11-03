package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;
import com.chainyu.noob.model.auth.domain.Role;


public interface RoleMapper {
    Role selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(Role role);

    int updateByIdSelective(Role role);

}