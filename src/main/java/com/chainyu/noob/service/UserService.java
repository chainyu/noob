package com.chainyu.noob.service;

import com.chainyu.noob.model.auth.domain.User;

public interface UserService {

	/**
	 * @param user
	 * @return
	 */
	public int save(User user);

	/**
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
