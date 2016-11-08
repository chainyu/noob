package com.chainyu.noob.dao.auth;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.dao.BaseMapper;
import com.chainyu.noob.model.auth.domain.User;

public interface UserMapper extends BaseMapper<User, Long>{

	/*test*/
	User findByUserName(@Param("userName")String userName);

}