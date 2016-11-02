package com.chainyu.noob.model.auth.domain;

import java.util.Date;

import com.chainyu.noob.model.BaseModel;

/**
 * 权限.
 * @author chainyu_zhang
 * @date 2016年11月2日 下午9:35:14
 */
public class Privilege extends BaseModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = -273093914973726254L;

	/** Id. */
	private Long id;

	/** 权限编码. */
	private String code;

	/** 权限名称. */
	private String name;

	/** 权限描述. */
	private String description;

	/** 权限分组. */
	private String groupName;

	/** 权限状态. */
	private Byte status;

	/** 创建时间. */
	private Date createTime;

	/** 更新时间. */
	private Date updateTime;

	
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
	 * Set the 权限编码.
	 * 
	 * @param code
	 *            权限编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the 权限编码.
	 * 
	 * @return 权限编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Set the 权限名称.
	 * 
	 * @param name
	 *            权限名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the 权限名称.
	 * 
	 * @return 权限名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the 权限描述.
	 * 
	 * @param description
	 *            权限描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the 权限描述.
	 * 
	 * @return 权限描述
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the 权限分组.
	 * 
	 * @param groupName
	 *            权限分组
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Get the 权限分组.
	 * 
	 * @return 权限分组
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Set the 权限状态.
	 * 
	 * @param status
	 *            权限状态
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * Get the 权限状态.
	 * 
	 * @return 权限状态
	 */
	public Byte getStatus() {
		return this.status;
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

	/**
	 * Set the 更新时间.
	 * 
	 * @param updateTime
	 *            更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Get the 更新时间.
	 * 
	 * @return 更新时间
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

}
