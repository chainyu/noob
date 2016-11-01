package com.chainyu.noob.web.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import com.chainyu.noob.model.constant.Constant;
import com.chainyu.noob.model.constant.ErrorCodes;
import com.chainyu.noob.utils.http.RequestUtil;
import com.chainyu.noob.utils.http.ResponseUtil;

/**
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:32:15
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	private String accessDeniedUrl;
	
	@Autowired
	private MessageSource		messageSource;

	public MyAccessDeniedHandler() {

	}

	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	public MyAccessDeniedHandler(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp,
			AccessDeniedException reason) throws ServletException, IOException {
		req.setCharacterEncoding(Constant.UTF8);
		resp.setCharacterEncoding(Constant.UTF8);
		String key =ErrorCodes.BUSINESS_EXCEPTION_PREFIX +ErrorCodes.ACCESS_DENIED ;
		Object[] args = new String[0];
		String message = messageSource.getMessage(key
				,args, key, LocaleContextHolder.getLocale());

		// 如果是ajax请求
		if (RequestUtil.isAjaxRequest(req)) {
			String jsonObject = "{\"message\":\""+message+"\","
					+ "\"denied\":true,\"cause\":\"AUTHORIZATION_FAILURE\"}";
			ResponseUtil.writeJson(resp, jsonObject);
		} else {
			String reqUrl =req.getRequestURI();
			if(accessDeniedUrl.indexOf(reqUrl) ==-1){
				String path = req.getContextPath();
				String basePath = req.getScheme() + "://" + req.getServerName()
						+ ":" + req.getServerPort() + path;
				resp.sendRedirect(basePath + accessDeniedUrl);
			}
		}
		return;

	}

}
