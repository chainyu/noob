package com.chainyu.noob.web.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.chainyu.noob.model.constant.ErrorCodes;
import com.chainyu.noob.utils.http.RequestUtil;
import com.chainyu.noob.utils.http.ResponseUtil;

@SuppressWarnings("deprecation")
public class MyLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	@Autowired
	private MessageSource messageSource;

	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// 如果是ajax请求
		if (RequestUtil.isAjaxRequest(request)) {
			String key = ErrorCodes.BUSINESS_EXCEPTION_PREFIX + ErrorCodes.INVALID_SESSION;
			Object[] args = new String[0];
			String message = messageSource.getMessage(key, args, key, LocaleContextHolder.getLocale());

			String jsonObject = "{\"message\":\"" + message + "\","
					+ "\"needlogin\":true,\"cause\":\"Access is denied\"}";
			ResponseUtil.writeJson(response, jsonObject);
			return;
		} else {
			super.commence(request, response, authException);
		}
	}
}
