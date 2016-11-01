/**
 * Copyright (c) 2015 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
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

import com.baozun.nebulaplus.constant.ErrorCodes;
import com.baozun.nebulaplus.http.RequestUtil;
import com.baozun.nebulaplus.http.ResponseUtil;

/**
 * @author D.C
 * @date 2015年10月19日 上午10:16:33
 */
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
