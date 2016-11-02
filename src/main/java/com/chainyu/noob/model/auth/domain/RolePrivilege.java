package com.chainyu.noob.model.auth.domain;

import java.util.Date;

import com.chainyu.noob.model.BaseModel;


/**
 * 角色权限.
 * @author chainyu_zhang
 * @date 2016年11月2日 下午9:38:03
 */
public class RolePrivilege extends BaseModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 6107622884906486845L;

	/** Id. */
	private Long id;

	/** 角色. */
	private Long roleId;

	/** 权限. */
	private Long privilegeId;

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
	 * Set the 角色.
	 * 
	 * @param roleId
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
	 * Set the 权限.
	 * 
	 * @param privilegeId
	 *            权限
	 */
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	/**
	 * Get the 权限.
	 * 
	 * @return 权限
	 */
	public Long getPrivilegeId() {
		return this.privilegeId;
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
