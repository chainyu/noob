package com.chainyu.noob.model.auth.command;

import java.util.List;

import com.chainyu.noob.model.BaseModel;

public class PrivilegeUrlRoleCommand extends BaseModel {

	private static final long serialVersionUID = 1L;

	private String url;
	
	private List<String> roleIds;
	
	public PrivilegeUrlRoleCommand(){
		super();
	}
	
	public PrivilegeUrlRoleCommand(String url, List<String> roleIds) {
		super();
		this.url = url;
		this.roleIds = roleIds;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}


}
