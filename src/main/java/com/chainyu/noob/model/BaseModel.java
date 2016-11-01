package com.chainyu.noob.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9191417055251440350L;

	/**
	 * 失效效/禁用 状态
	 */
	public static final Byte STATUS_DISABLE = 0;
	
	/**
	 * 有效/启用 状态
	 */
	public static final Byte STATUS_ENABLE = 1;
	
	/**
	 * 激活/开通 状态
	 */
	public static final Byte STATUS_ACTIVE = 2;
	
	/**
	 * 默认状态为有效状态
	 */
	public static final Byte DEFAULT_STATUS	= STATUS_ENABLE;
	

}
