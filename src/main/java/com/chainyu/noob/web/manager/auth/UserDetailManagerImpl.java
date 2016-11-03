package com.chainyu.noob.web.manager.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chainyu.noob.model.auth.command.MyUserDetails;
import com.chainyu.noob.model.auth.domain.Role;
import com.chainyu.noob.model.auth.domain.User;
import com.chainyu.noob.service.UserService;
import com.chainyu.noob.service.UserRoleService;
import com.chainyu.noob.utils.Validator;



/**
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:27:47
 */
@Service
public class UserDetailManagerImpl implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	
	/**
	 * 加载用户信息、获取权限
	 */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user=userService.findByUserName(userName);
		if(Validator.isNullOrEmpty(user))
			throw new UsernameNotFoundException(userName+": not fond.");
		List<Role> userRoles=userRoleService.findByUserId(user.getId());
		List<GrantedAuthority>	grantedAuthorities =new ArrayList<GrantedAuthority>();
		if(Validator.isNotNullOrEmpty(userRoles)){
			for (Role role : userRoles) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getId().toString()));
			}
		}
		return new MyUserDetails(grantedAuthorities, user);
		
	}
}