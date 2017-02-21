package com.brp.entity;

import java.sql.Date;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CustomerEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class CustomerEntity extends BaseEntity{
	private String customerName; //客户名称
	private String createUserId;
	private String updateUserId;
	private Integer customerLevel; //客户级别
	private Integer trade; //行业
	private String mobile; //联系电话
	private String companyWebSite; //公司网址
	private String superCustomer; //上级
	private String detailAddress; //详细地址
	private String saleMoney; //销售额
	private Date lastActivityRecordTime;//最近活动记录时间
	private Integer lockStatus; //锁定状态
	private String beyondDepartmentId; //所属部门
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Integer getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}
	public Integer getTrade() {
		return trade;
	}
	public void setTrade(Integer trade) {
		this.trade = trade;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCompanyWebSite() {
		return companyWebSite;
	}
	public void setCompanyWebSite(String companyWebSite) {
		this.companyWebSite = companyWebSite;
	}
	public String getSuperCustomer() {
		return superCustomer;
	}
	public void setSuperCustomer(String superCustomer) {
		this.superCustomer = superCustomer;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(String saleMoney) {
		this.saleMoney = saleMoney;
	}
	public Date getLastActivityRecordTime() {
		return lastActivityRecordTime;
	}
	public void setLastActivityRecordTime(Date lastActivityRecordTime) {
		this.lastActivityRecordTime = lastActivityRecordTime;
	}
	public Integer getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(Integer lockStatus) {
		this.lockStatus = lockStatus;
	}
	public String getBeyondDepartmentId() {
		return beyondDepartmentId;
	}
	public void setBeyondDepartmentId(String beyondDepartmentId) {
		this.beyondDepartmentId = beyondDepartmentId;
	}
	
}

