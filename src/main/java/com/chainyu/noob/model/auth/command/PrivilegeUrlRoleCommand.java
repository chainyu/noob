package com.chainyu.noob.model.auth.command;

import com.chainyu.noob.model.auth.domain.PrivilegeUrl;

public class PrivilegeUrlRoleCommand extends PrivilegeUrl {

	private static final long serialVersionUID = 1L;

	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
