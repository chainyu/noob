package com.chainyu.noob.web.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.util.WebUtils;

/**
 * @author chainyu_zhang
 * @date 2016年11月7日 下午10:34:15
 */
public class SecurityCommonsMultipartResolver extends CommonsMultipartResolver {
	@Override
	public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {

		MultipartHttpServletRequest multipartHttpServletRequest = WebUtils.getNativeRequest(request,
				MultipartHttpServletRequest.class);
		if (multipartHttpServletRequest != null) {
			return multipartHttpServletRequest;
		}

		// If MultipartHttpServletRequest instance is not present, parse multipart request
		return new SecurityWrapperMultipartRequest(super.resolveMultipart(request));
	}
}
