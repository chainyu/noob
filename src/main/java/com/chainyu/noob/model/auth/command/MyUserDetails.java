package com.chainyu.noob.model.auth.command;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.chainyu.noob.model.BaseModel;
import com.chainyu.noob.model.auth.domain.User;



public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails,Serializable{
	
	private static final long serialVersionUID = -8865518245292296574L;

	/**
	 * 这里获取用户所有的角色
	 * 
	 */
	private Collection<GrantedAuthority>	authorities;

	/**
	 * 用户信息
	 */
	private User user ;
	
	private Boolean isAdmin;
	

	public Boolean getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public MyUserDetails() {
		super();
	}
	

	public MyUserDetails(Collection<GrantedAuthority> authorities, User user,boolean isAdmin) {
		super();
		this.authorities = authorities;
		this.user = user;
		this.isAdmin=isAdmin;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




	@Override
	public boolean isEnabled() {
		return user.getStatus().intValue() == BaseModel.STATUS_ENABLE.intValue();
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getUser().getPassword();
	}



	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getUser().getUserName();
	}



	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	/*
	 * equals 和 hashCode 方法必须重写，spring security在限制同一用户的登录次数时，判断是否为同一用户的关键在这里
	 */
	public boolean equals(Object object){
		if (object instanceof MyUserDetails){
			if (this.user.getId().longValue() == ((MyUserDetails) object).getUser().getId().longValue()){
				return true;
			}
		}
		return false;
	}

	public int hashCode(){
		return this.user.getId().intValue();
	}

}
