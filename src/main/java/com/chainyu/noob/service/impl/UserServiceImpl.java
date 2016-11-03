package com.chainyu.noob.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainyu.noob.dao.auth.UserMapper;
import com.chainyu.noob.model.auth.domain.User;
import com.chainyu.noob.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(User user) {
		int insert = userMapper.save(user);
		return insert;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
