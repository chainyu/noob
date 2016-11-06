package com.chainyu.noob.service.auth;

import java.util.List;

import com.chainyu.noob.model.auth.command.PrivilegeUrlRoleCommand;


public interface PrivilegeUrlService {

	/**
	 * @return
	 */
	public List<PrivilegeUrlRoleCommand> findAllPrivilegeUrlRoles();


}
