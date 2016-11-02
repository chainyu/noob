package com.chainyu.noob.model.auth.domain;

import java.util.Date;

import com.chainyu.noob.model.BaseModel;


/**
 * 权限URL.
 * @author chainyu_zhang
 * @date 2016年11月2日 下午9:37:11
 */

public class PrivilegeUrl extends BaseModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1323098822852972395L;

	/** Id. */
	private Long id;

	/** 权限. */
	private Long privilegeId;

	/** 对应的URL. */
	private String url;

	/** 描述. */
	private String description;

	/** 状态. */
	private Byte status;

	/** 创建时间. */
	private Date createTime;

	/** 修改时间. */
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
	 * Set the 对应的URL.
	 * 
	 * @param url
	 *            对应的URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the 对应的URL.
	 * 
	 * @return 对应的URL
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Set the 描述.
	 * 
	 * @param description
	 *            描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the 描述.
	 * 
	 * @return 描述
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the 状态.
	 * 
	 * @param status
	 *            状态
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * Get the 状态.
	 * 
	 * @return 状态
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
	 * Set the 修改时间.
	 * 
	 * @param updateTime
	 *            修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Get the 修改时间.
	 * 
	 * @return 修改时间
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

}
