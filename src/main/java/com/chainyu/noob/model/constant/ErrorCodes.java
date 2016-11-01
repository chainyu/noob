package com.chainyu.noob.model.constant;

/**
 * 自定义错误码,see businessException.properties
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:35:18
 */
public interface ErrorCodes {

	/** The Constant BUSINESS_EXCEPTION_PREFIX. */
	public static final String	BUSINESS_EXCEPTION_PREFIX	        = "business_exception_";

	/** 系统错误. */
	public static final Integer	SYSTEM_ERROR				        = 1;

	/** 无权访问. */
	public static final Integer	ACCESS_DENIED				        = 2;

	/** SESSION无效. */
	public static final Integer	INVALID_SESSION				        = 3;

	/** 数据错误. */
	public static final Integer	DATA_ERROR					        = 4;
	
	/** 用户名或密码错误*/
	public static final Integer	NAME_PWD_ERROR					    = 5;
	
	/** 系统用户不可访问店铺*/
	public static final Integer	NOT_THIS_STORE_USER					= 6;
	
	/** 角色已被删除*/
	public static final Integer	ROLE_NOT_EXISTS						= 7;
	
	/** 用户名不存在*/
	public static final Integer	USER_NOT_EXISTS						= 8;
	
	/** 发送失败*/
	public static final Integer	FAIL_SEND_PWD_EMAIL					= 9;
	
	/** 数据已被删除*/
	public static final Integer	DATA_BE_DELETE						= 10;
	
	/************************** 文件上传相关 **************************/
	/** 文件上传传出错 */
	public static final Integer	FILE_UPLOAD_IO_ERROR		        = 20001;
	
	/** 文件大小超过限制 */
	public static final Integer	FILE_UPLOAD_SIZE_EXCEEDS_LIMIT		= 20002;
	
	/** 文件类型不符合要求 */
	public static final Integer	FILE_UPLOAD_INVALID_CONTENTTYPE		= 20003;
	
	/** 文件为空 */
	public static final Integer FILE_UPLOAD_FILE_EMPTY              = 20004;
	
	/************************** 权限相关 **************************/
	/** 赋权限用户中存在已删除或已失效用户 */
	public static final Integer USER_ROLE_USER_NUM_NOT_MATCH        = 30001;
	
	public static final Integer COUPON_CODE_NOT_ENOUGH              = 40001;

	public static final Integer MEMBERS_HAVE_COUPON_CODE            = 40002;
	
	public static final Integer INVENTORY_LESS_THAN_SENT            = 40003;
	
	public static final Integer NO_COUPON_CODES_AVAILABLE           = 40004;
	
	
	/************************** 数据已经存在 *************************/
	public static final Integer DATA_EXIST						    = 60003;
	
}
