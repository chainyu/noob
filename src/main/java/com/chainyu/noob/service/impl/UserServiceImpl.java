package com.chainyu.noob.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainyu.noob.dao.auth.UserMapper;
import com.chainyu.noob.model.auth.domain.User;
import com.chainyu.noob.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userDao;
	
	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}
