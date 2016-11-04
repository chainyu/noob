package com.chainyu.noob.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainyu.noob.dao.auth.PrivilegeUrlMapper;
import com.chainyu.noob.dao.auth.RolePrivilegeMapper;
import com.chainyu.noob.model.auth.command.PrivilegeUrlRoleCommand;
import com.chainyu.noob.model.auth.domain.PrivilegeUrl;
import com.chainyu.noob.model.auth.domain.RolePrivilege;
import com.chainyu.noob.service.PrivilegeUrlService;
import com.chainyu.noob.utils.Validator;

@Service
public class PrivilegeUrlServiceImpl implements PrivilegeUrlService{

	@Autowired
	private PrivilegeUrlMapper privilegeUrlDao;
	
	@Autowired
	private RolePrivilegeMapper rolePrivilegeDao;
	
	@Override
	public List<PrivilegeUrlRoleCommand> findAllPrivilegeUrlRoles() {
		List<PrivilegeUrlRoleCommand> privilegeUrlRoles=null;
		List<PrivilegeUrl> privilegeUrls = privilegeUrlDao.findAll();
		if(Validator.isNotNullOrEmpty(privilegeUrls)){
			privilegeUrlRoles=new ArrayList<PrivilegeUrlRoleCommand>();
			for (PrivilegeUrl privilegeUrl : privilegeUrls) {
				List<RolePrivilege> rolePrivileges=rolePrivilegeDao.findByPrivilegeId(privilegeUrl.getPrivilegeId());
				List<String> roleIds=new ArrayList<String>();
				if(Validator.isNotNullOrEmpty(rolePrivileges)){
					for (RolePrivilege rolePrivilege : rolePrivileges) {
						roleIds.add(rolePrivilege.getRoleId().toString());
					}
				}
				PrivilegeUrlRoleCommand privilegeUrlRoleCommand=new PrivilegeUrlRoleCommand(privilegeUrl.getUrl(), roleIds);
				privilegeUrlRoles.add(privilegeUrlRoleCommand);
			}
		}
		return privilegeUrlRoles;
	}



}
