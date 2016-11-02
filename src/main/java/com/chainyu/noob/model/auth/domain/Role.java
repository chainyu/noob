package com.chainyu.noob.model.auth.domain;

import java.util.Date;

import com.chainyu.noob.model.BaseModel;

public class Role extends BaseModel{

	private static final long serialVersionUID = -7418427294192155867L;


	/** Id. */
	private Long id;

	/** 角色名称. */
	private String name;

	/** 角色描述. */
	private String description;

	/** 所属店铺. */
	private Long storeId;

	/** 状态. */
	private Byte status;

	/** 创建时间. */
	private Date createTime;
	
	/** 更新时间. */
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
