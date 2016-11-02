package com.chainyu.noob.model.auth.domain;

import java.util.Date;

import com.chainyu.noob.model.BaseModel;

/**
 * 用户角色.
 * @author chainyu_zhang
 * @date 2016年11月2日 下午9:39:51
 */
public class UserRole extends BaseModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 7400568227624816177L;

	/** Id. */
	private Long id;

	/** 用户. */
	private Long userId;

	/** 角色. */
	private Long roleId;

	/** 创建时间. */
	private Date createTime;


	/**
	 * Set the Id.
	 * 
	 * @param id
	 *            Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the Id.
	 * 
	 * @return Id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the 用户.
	 * 
	 * @param userTAuUser
	 *            用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Get the 用户.
	 * 
	 * @return 用户
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * Set the 角色.
	 * 
	 * @param roleTAuRole
	 *            角色
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Get the 角色.
	 * 
	 * @return 角色
	 */
	public Long getRoleId() {
		return this.roleId;
	}


	/**
	 * Set the 创建时间.
	 * 
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Get the 创建时间.
	 * 
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

}
