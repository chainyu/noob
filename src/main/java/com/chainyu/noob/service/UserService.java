package com.chainyu.noob.service;

import com.chainyu.noob.model.auth.domain.User;

public interface UserService {

	public int insert(User user);

	public User findByUserName(String userName);
}
