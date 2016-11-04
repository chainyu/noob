package com.chainyu.noob.service;

import java.util.List;

import com.chainyu.noob.model.auth.command.PrivilegeUrlRoleCommand;


public interface PrivilegeUrlService {

	/**
	 * @return
	 */
	public List<PrivilegeUrlRoleCommand> findAllPrivilegeUrlRoles();


}
