package com.chainyu.noob.web.manager.auth;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import com.chainyu.noob.model.auth.command.MyUserDetails;


/**
 * 验证用户是否拥有所请求资源的权限
 * 发生于用户请求某个链接时，默认会过滤所有的请求
 */
@Service
public class AccessDecisionManagerImpl implements AccessDecisionManager {
	
	private static final Logger LOGGER = Logger.getLogger(AccessDecisionManagerImpl.class);

	// In this method, need to compare authentication with configAttributes.
	// 1, A object is a URL, a filter was find permission configuration by this
	// URL, and pass to here.
	// 2, Check authentication has attribute in permission configuration
	// (configAttributes)
	// 3, If not match corresponding authentication, throw a
	// AccessDeniedException.
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		FilterInvocation fi = (FilterInvocation)object;
		Object principal = authentication.getPrincipal();
		if (configAttributes == null || principal instanceof String) {
			return;
		}
		MyUserDetails userDetails = (MyUserDetails) principal;
		
		
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		

		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			//先判断当前url需要哪些角色
			String needPrivilege = ((SecurityConfig) ca).getAttribute();
			for (GrantedAuthority ga : userDetails.getAuthorities()) {
				if (needPrivilege.equals(ga.getAuthority())) {
					LOGGER.info("accessLog:" + userDetails.getUser().getId() + ":" + userDetails.getUsername()+ ":" + fi.getRequestUrl());
					return;
				}
			}
		}
		throw new AccessDeniedException("no right");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
