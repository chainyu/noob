package com.chainyu.noob.web.security.auth;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author chainyu_zhang
 * @date 2016年11月1日 下午9:43:51
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static final Logger LOGGER = Logger.getLogger(MyUsernamePasswordAuthenticationFilter.class);
	
	
	@Override
	protected String obtainPassword(HttpServletRequest request) {
		//TODO 自定义加解密算法
		String original = request.getParameter(getPasswordParameter());
		LOGGER.debug("MyUsernamePasswordAuthenticationFilter......original["+original+"]");
		return original;
	}
}
