package com.chainyu.noob.web.manager.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



/**
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:27:47
 */
@Service
public class UserDetailManagerImpl implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		//TODO 加载用户信息、获取权限
		return null;
		
	}
}