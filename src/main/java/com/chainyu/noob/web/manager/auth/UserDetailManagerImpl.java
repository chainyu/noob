package com.chainyu.noob.web.manager.auth;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.chainyu.noob.model.auth.command.MyUserDetails;
import com.chainyu.noob.model.auth.domain.User;



/**
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:27:47
 */
@Service
public class UserDetailManagerImpl implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		/*User user =reservedUserService.findUserByUsername(userName);
		if(user==null){
			throw new UsernameNotFoundException(userName + " is not existed.");
		}else {
			if(Validator.isNullOrEmpty(user.getStoreId())){
				//store id cann't be null
				throw new UsernameNotFoundException("store id cann't be null.");
			}
			Store uStore =storeService.findStoreByCode(Store.OP_CODE);
			if(Validator.isNotNullOrEmpty(uStore) && user.getStoreId().equals(uStore.getId())){
				//op user无权访问
				throw new NotSelfStoreAccessException("op user access denied.");
			}
		}
		return constructUserDetails(user);*/
		return null;
		
	}

	/**
	 * 
	 * 补充用户信息(授权、是否店长等)
	 * @param user
	 * @return
	 */
	private MyUserDetails constructUserDetails(User user) {
		
		List<GrantedAuthority>	grantedAuthorities =new ArrayList<GrantedAuthority>();
		/*List<Role> roleList =reservedUserRoleService.
				findRoleByUserIdAndStoreId(user.getId(), storeId);
		if(Validator.isNotNullOrEmpty(roleList)){
			for (Role role : roleList) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getId().toString()));
			}
		}*/
		MyUserDetails myUserDetails =new MyUserDetails(grantedAuthorities, user);
		return myUserDetails;
	}
}