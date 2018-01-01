package com.wangsd.web.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 菜单名称
     */
	private String menuName;
    /**
     * 父级菜单ID
     */
	private String parentId;
    /**
     * 连接地址
     */
	private String url;
    /**
     * 图标
     */
	private String icon;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 菜单状态,1-启用,-1禁用
     */
	private Integer roleState;
    /**
     * 资源名称
     */
	private String resource;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getRoleState() {
		return roleState;
	}

	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysMenu{" +
			", id=" + id +
			", menuName=" + menuName +
			", parentId=" + parentId +
			", url=" + url +
			", icon=" + icon +
			", sort=" + sort +
			", roleState=" + roleState +
			", resource=" + resource +
			"}";
	}
}
