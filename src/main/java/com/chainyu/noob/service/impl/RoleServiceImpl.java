package com.chainyu.noob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainyu.noob.dao.auth.RoleMapper;
import com.chainyu.noob.model.auth.domain.Role;
import com.chainyu.noob.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleDao;
	
	@Override
	public List<Role> findByUserId(Long id) {
		return roleDao.findByUserId(id);
	}

}
