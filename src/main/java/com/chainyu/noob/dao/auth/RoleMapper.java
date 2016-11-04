package com.chainyu.noob.dao.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.dao.BaseMapper;
import com.chainyu.noob.model.auth.domain.Role;


public interface RoleMapper extends BaseMapper<Role, Long>{

	List<Role> findByUserId(@Param("userId")Long userId);

}