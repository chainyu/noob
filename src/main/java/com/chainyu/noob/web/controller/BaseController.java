package com.chainyu.noob.web.controller;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;

import com.chainyu.noob.model.constant.ErrorCodes;
import com.chainyu.noob.utils.Validator;

public class BaseController {
	
	@Resource
	protected ApplicationContext context;
	
	/**
	 * 获得消息信息
	 * 
	 * @param errorCode
	 * @return
	 */
	protected String getMessage(Integer errorCode) {
		if (Validator.isNotNullOrEmpty(errorCode)) {
			Object[] args = null;
			return getMessage(errorCode, args);
		}
		return null;
	}

	/**
	 * 获得消息信息
	 * 
	 * @param errorCode
	 * @return
	 */
	protected String getMessage(String errorCode) {
		if (Validator.isNotNullOrEmpty(errorCode)) {
			Object[] args = null;
			return getMessage(errorCode, args);
		}
		return null;
	}

	/**
	 * 获得消息信息
	 * 
	 * @param errorCode
	 * @param args
	 * @return
	 */
	protected String getMessage(Integer errorCode, Object... args) {
		if (Validator.isNotNullOrEmpty(errorCode)) {
			return getMessage(ErrorCodes.BUSINESS_EXCEPTION_PREFIX + errorCode, args);
		}
		return null;
	}

	/**
	 * 获得消息信息
	 * 
	 * @param code
	 * @param args
	 * @return
	 */
	protected String getMessage(String code, Object... args) {
		if (Validator.isNotNullOrEmpty(code)) {
			return context.getMessage(code, args, LocaleContextHolder.getLocale());
		}
		return null;
	}

	/**
	 * 获得消息信息
	 * 
	 * @param messageSourceResolvable
	 *            适用于 ObjectError 以及 FieldError
	 * @return
	 */
	protected String getMessage(MessageSourceResolvable messageSourceResolvable) {
		return context.getMessage(messageSourceResolvable, LocaleContextHolder.getLocale());
	}
}
