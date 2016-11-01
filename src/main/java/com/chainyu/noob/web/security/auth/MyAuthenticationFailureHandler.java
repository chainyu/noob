package com.chainyu.noob.web.security.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.LocaleResolver;

import com.baozun.nebulaplus.constant.Constant;
import com.baozun.nebulaplus.constant.ErrorCodes;
import com.baozun.nebulaplus.exception.NotSelfStoreAccessException;
import com.baozun.nebulaplus.http.RequestUtil;
import com.baozun.nebulaplus.util.Validator;
import com.baozun.service.auth.api.ReservedUserLoginLogService;
import com.baozun.service.auth.api.ReservedUserService;
import com.baozun.service.auth.model.User;
import com.baozun.service.auth.model.UserLoginLog;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private LocaleResolver localeResolver;
	
	@Autowired
	private ReservedUserLoginLogService  reservedUserLoginLogService;
	
	@Autowired
	ReservedUserService  reservedUserService;

	private String loginFormUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,
			AuthenticationException exception) throws IOException, ServletException {
		
		User user = getUser(req);
		int  userLoginFailFrequency = 0;
		boolean redirectLoginPageFlag = true;
		if(Validator.isNotNullOrEmpty(user)){
			insertLoginFaillog(req,user);
			userLoginFailFrequency = checkUninterrupteFailFrequency(user) ;
			if(userLoginFailFrequency >= Constant.ALLOW_USER_LOGIN_FAIL_FREQUENCY){
				redirectLoginPageFlag = false;
				changeLockStatusforUser(user);
				forwardLockPage(req,resp,user);
			}
		}
		if(Validator.isNullOrEmpty(user) || redirectLoginPageFlag){
			redirectLoginPage( exception ,  req ,  resp,  userLoginFailFrequency);
		}
	}
	
	private User getUser(HttpServletRequest req){
		String userName = req.getParameter(Constant.USER_LOGIN_NAME_PARAMETER);
		User user = reservedUserService.findUserByUsernameAndStatus(userName,null);
		return user ;
	}
	
	
	/**
	 * 跳转到登录页面
	 * @param exception
	 * @param req
	 * @param resp
	 * @param userLoginFailFrequency
	 * @throws IOException
	 */
	private void redirectLoginPage(AuthenticationException exception , HttpServletRequest req , HttpServletResponse resp, int userLoginFailFrequency) throws IOException{
		String errorMessage = getErrorMessage( exception ,  req ,  userLoginFailFrequency);
		if(!StringUtils.isEmpty(errorMessage)) {
			req.getSession().setAttribute("errMessage", errorMessage);
		}
		String reqUrl = req.getRequestURI();
		if (loginFormUrl.indexOf(reqUrl) == -1) {
			resp.sendRedirect(loginFormUrl);
		}
	}

	public String getLoginFormUrl() {
		return loginFormUrl;
	}

	public void setLoginFormUrl(String loginFormUrl) {
		this.loginFormUrl = loginFormUrl;
	}
	
	/**
	 * 用户变更为锁定状态
	 */
	private void changeLockStatusforUser(User user){
		List<Long> ids = new ArrayList<Long>();
		ids.add(user.getId());
		reservedUserService.enableOrDisableUser(ids, Integer.valueOf(User.USER_STATUS_LOCKED));
	}
	
	/**
	 * 跳转到锁定页面
	 * @param request
	 * @param response
	 * @param user
	 * @throws ServletException
	 * @throws IOException
	 */
	private void forwardLockPage(ServletRequest request, ServletResponse response , User user) throws ServletException, IOException{
		Date currentDate = new Date();
		request.setAttribute("username", user.getUserName());
		request.setAttribute("unlockTime", new Date(currentDate.getTime()+Constant.USER_LOGIN_FAIL_LOCKED_TIME));
		request.getRequestDispatcher("/pages/auth/user-lock.jsp").forward(request, response);
	}
	/**
	 * 错误提示信息
	 * @param exception
	 * @param req
	 * @return
	 */
	private String getErrorMessage(AuthenticationException exception , HttpServletRequest req , int frequency){

		String key = "";
		if (exception instanceof InternalAuthenticationServiceException) {
			InternalAuthenticationServiceException el = (InternalAuthenticationServiceException) exception;
			if (el.getCause().getClass() == NotSelfStoreAccessException.class) {
				key = ErrorCodes.BUSINESS_EXCEPTION_PREFIX + ErrorCodes.NOT_THIS_STORE_USER;
			}
		} else if (exception instanceof BadCredentialsException) {
			key = ErrorCodes.BUSINESS_EXCEPTION_PREFIX + ErrorCodes.NAME_PWD_ERROR;
		}
		String failMessage = messageSource.getMessage(key, new String[0], localeResolver.resolveLocale(req));
		if(StringUtils.isEmpty(failMessage)){
			return null;
		}
        StringBuffer errorMessage = new StringBuffer();
        errorMessage.append(failMessage);
		errorMessage.append("<br>");
		errorMessage.append(messageSource.getMessage(ErrorCodes.BUSINESS_EXCEPTION_PREFIX + ErrorCodes.NAME_PWD_ERROR_LOCK_TIP, new String[0],localeResolver.resolveLocale(req)));
		if(frequency > 1){
			errorMessage.append("<br>");
			Integer remainFrequency =  (int) (Constant.ALLOW_USER_LOGIN_FAIL_FREQUENCY -frequency) ;
			remainFrequency = remainFrequency.intValue() < 0 ? 0 : remainFrequency.intValue();
			errorMessage.append(messageSource.getMessage(ErrorCodes.BUSINESS_EXCEPTION_PREFIX + ErrorCodes.NAME_PWD_ERROR_REMAIN_FREQUENCY, new String[0], localeResolver.resolveLocale(req)).replace("{0}", remainFrequency.toString()));
		}
		return errorMessage.toString();
	}
	
	/**
	 * 插入登录失败日志
	 * @param req
	 * @param exception
	 */
	private void insertLoginFaillog(HttpServletRequest req ,User user){
		UserLoginLog log = new UserLoginLog();
		log.setIp(RequestUtil.getClientIp(req));
		log.setLoginTime(new Date());
		log.setSessionId(req.getSession().getId());
		log.setStatus(UserLoginLog.USER_LOGIN_FAIL);
		log.setStoreId(user.getStoreId());
		log.setUserId(user.getId());
		
		reservedUserLoginLogService.save(log);
	}
	
	/**
	 * 查出一段时间内连续登录失败的次数
	 * @return
	 */
	private int checkUninterrupteFailFrequency(User user){
		List<UserLoginLog> logs = reservedUserLoginLogService.findByStoreIdAndUserIdAndStatus(user.getStoreId(), user.getId(), UserLoginLog.USER_LOGIN_FAIL,Constant.ALLOW_USER_UNINTERRUPTE_LOGIN_TIME);
		
		return Validator.isNotNullOrEmpty(logs) ? logs.size() : 0;
	}

}
