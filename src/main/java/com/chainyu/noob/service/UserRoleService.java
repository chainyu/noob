package com.chainyu.noob.service;

import java.util.List;

import com.chainyu.noob.model.auth.domain.Role;

public interface UserRoleService {

	public List<Role> findByUserId(Long id);

}
