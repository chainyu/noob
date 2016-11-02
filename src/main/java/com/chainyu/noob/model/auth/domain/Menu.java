package com.chainyu.noob.model.auth.domain;

import java.util.Date;
import java.util.List;

import com.chainyu.noob.model.BaseModel;

/**
 * 菜单.
 * @author chainyu_zhang
 * @date 2016年11月2日 下午9:33:54
 */
public class Menu extends BaseModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Id. */
	private Long id;

	/** 菜单名称. */
	private String label;

	/** 菜单序号. */
	private Integer sortNo;

	/** 路径. */
	private String url;

	/** 自身关联. */
	private Long parent;

	/** 图标. */
	private String icon;

	/** 状态. */
	private Byte status;

	/** 创建时间. */
	private Date createTime;

	/** 更新时间. */
	private Date updateTime;
	
	private List<Menu> children;

	
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
	 * Set the 菜单名称.
	 * 
	 * @param label
	 *            菜单名称
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Get the 菜单名称.
	 * 
	 * @return 菜单名称
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Set the 菜单序号.
	 * 
	 * @param sortNo
	 *            菜单序号
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * Get the 菜单序号.
	 * 
	 * @return 菜单序号
	 */
	public Integer getSortNo() {
		return this.sortNo;
	}

	/**
	 * Set the 路径.
	 * 
	 * @param url
	 *            路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the 路径.
	 * 
	 * @return 路径
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Set the 自身关联.
	 * 
	 * @param parent
	 *            自身关联
	 */
	public void setParent(Long parent) {
		this.parent = parent;
	}

	/**
	 * Get the 自身关联.
	 * 
	 * @return 自身关联
	 */
	public Long getParent() {
		return this.parent;
	}

	/**
	 * Set the 图标.
	 * 
	 * @param icon
	 *            图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Get the 图标.
	 * 
	 * @return 图标
	 */
	public String getIcon() {
		return this.icon;
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
	
	

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Menu){
			if(this.getId().longValue() ==((Menu) obj).getId().longValue())
			return true ;	
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.getId().intValue();
	}
	
	
}
