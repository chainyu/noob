package com.chainyu.noob.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author chainyu_zhang
 * @date 2016年10月23日 下午9:17:56
 */
public class SecurityWrapperRequest extends HttpServletRequestWrapper {

	public SecurityWrapperRequest(HttpServletRequest request) {
		super(request);
	}

	public String[] getParameterValues(String paramString) {
		String[] arrayOfString1 = super.getParameterValues(paramString);
		if (arrayOfString1 == null)
			return null;
		int i = arrayOfString1.length;
		String[] arrayOfString2 = new String[i];
		for (int j = 0; j < i; j++)
			arrayOfString2[j] = SecurityProcessor.process(this, paramString, arrayOfString1[j]);
		return arrayOfString2;
	}

	public String getParameter(String paramString) {
		String str = super.getParameter(paramString);
		if (str == null)
			return null;
		return SecurityProcessor.process(this, paramString, str);
	}

	public String getHeader(String paramString) {
		String str = super.getHeader(paramString);
		if (str == null)
			return null;
		return SecurityProcessor.process(this, paramString, str);
	}
}
