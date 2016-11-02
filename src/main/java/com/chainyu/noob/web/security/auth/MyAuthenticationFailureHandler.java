package com.chainyu.noob.web.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	private String loginFormUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,
			AuthenticationException exception) throws IOException, ServletException {
		resp.sendRedirect(loginFormUrl);
	}
	

	public String getLoginFormUrl() {
		return loginFormUrl;
	}

	public void setLoginFormUrl(String loginFormUrl) {
		this.loginFormUrl = loginFormUrl;
	}
	

}
