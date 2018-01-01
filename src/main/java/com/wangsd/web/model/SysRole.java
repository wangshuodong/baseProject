package com.wangsd.web.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 角色描述
     */
	private String roleDesc;
    /**
     * 1代表服务商，2代表物业，3代表小区,99管理员
     */
	private Integer roleType;
    /**
     * 状态,1-启用,-1禁用
     */
	private Integer roleState;
    /**
     * 创建时间
     */
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getRoleState() {
		return roleState;
	}

	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysRole{" +
			", id=" + id +
			", roleName=" + roleName +
			", roleDesc=" + roleDesc +
			", roleType=" + roleType +
			", roleState=" + roleState +
			", createTime=" + createTime +
			"}";
	}
}
