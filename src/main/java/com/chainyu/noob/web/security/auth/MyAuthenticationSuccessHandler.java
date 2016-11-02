package com.chainyu.noob.web.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	/*
	 * 登录成功后，读取用户角色，加载用户可访问菜单，记录登录日志
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.sendRedirect("index.htm");
	}
	
}
