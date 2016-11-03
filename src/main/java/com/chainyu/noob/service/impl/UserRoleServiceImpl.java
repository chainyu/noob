package com.chainyu.noob.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainyu.noob.model.auth.domain.Role;
import com.chainyu.noob.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Override
	public List<Role> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
