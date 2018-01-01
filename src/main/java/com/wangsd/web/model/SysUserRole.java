package com.wangsd.web.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
@TableName("sys_user_role")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="Id", type= IdType.AUTO)
	private Long Id;
    /**
     * 用户主键
     */
	private Long userId;
    /**
     * 角色主键
     */
	private Long roleId;


	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
			", Id=" + Id +
			", userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
