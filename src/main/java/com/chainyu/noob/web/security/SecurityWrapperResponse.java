package com.chainyu.noob.web.security;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author chainyu_zhang
 * @date 2016年10月23日 下午9:18:10
 */
public class SecurityWrapperResponse extends HttpServletResponseWrapper {

	public SecurityWrapperResponse(HttpServletResponse response) {
	    super(response);
    }

}
