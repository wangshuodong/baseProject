package com.wangsd.web.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 部门编号
     */
	private String code;
    /**
     * 部门名称
     */
	private String deptName;
    /**
     * 顶级服务商id
     */
	private Integer serviceId;
    /**
     * 直接上级id
     */
	private Integer parentId;
    /**
     * 区域
     */
	private String region;
    /**
     * 联系人
     */
	@TableField("contact_people")
	private String contactPeople;
    /**
     * 联系电话
     */
	@TableField("contact_phone")
	private String contactPhone;
    /**
     * 联系地址
     */
	@TableField("contact_address")
	private String contactAddress;
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getContactPeople() {
		return contactPeople;
	}

	public void setContactPeople(String contactPeople) {
		this.contactPeople = contactPeople;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
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
		return "Department{" +
			", id=" + id +
			", code=" + code +
			", deptName=" + deptName +
			", serviceId=" + serviceId +
			", parentId=" + parentId +
			", region=" + region +
			", contactPeople=" + contactPeople +
			", contactPhone=" + contactPhone +
			", contactAddress=" + contactAddress +
			", createTime=" + createTime +
			"}";
	}
}
