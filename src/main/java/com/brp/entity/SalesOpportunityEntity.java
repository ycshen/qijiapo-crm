package com.brp.entity;

import java.util.Date;

/**
 * 销售机会
 * @author Administrator
 *
 */
public class SalesOpportunityEntity extends BaseEntity{
	private String customerName; //客户名称
	private String oppotunityType; //机会类型
	private String saleMoney; //销售金额
	private Date endOppoTime; //结单日期
	private Integer saleStage;//销售阶段
	private String winRate; //赢率
	private Date stageUpdateTime; //阶段更新时间
	private String marketActivityId; //市场活动
	private Integer lockStatus; //锁定状态
	private String failStage; //输单阶段
	private Integer failOrderReason; //输单原因
	private String failDesc; //输单描述
	private String remark; //备注
	private String productId; //产品
	private Date lastUpdateTime; //最新修改日
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOppotunityType() {
		return oppotunityType;
	}
	public void setOppotunityType(String oppotunityType) {
		this.oppotunityType = oppotunityType;
	}
	public String getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(String saleMoney) {
		this.saleMoney = saleMoney;
	}
	public Date getEndOppoTime() {
		return endOppoTime;
	}
	public void setEndOppoTime(Date endOppoTime) {
		this.endOppoTime = endOppoTime;
	}
	public Integer getSaleStage() {
		return saleStage;
	}
	public void setSaleStage(Integer saleStage) {
		this.saleStage = saleStage;
	}
	public String getWinRate() {
		return winRate;
	}
	public void setWinRate(String winRate) {
		this.winRate = winRate;
	}
	public Date getStageUpdateTime() {
		return stageUpdateTime;
	}
	public void setStageUpdateTime(Date stageUpdateTime) {
		this.stageUpdateTime = stageUpdateTime;
	}
	public String getMarketActivityId() {
		return marketActivityId;
	}
	public void setMarketActivityId(String marketActivityId) {
		this.marketActivityId = marketActivityId;
	}
	public Integer getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(Integer lockStatus) {
		this.lockStatus = lockStatus;
	}
	public String getFailStage() {
		return failStage;
	}
	public void setFailStage(String failStage) {
		this.failStage = failStage;
	}
	public Integer getFailOrderReason() {
		return failOrderReason;
	}
	public void setFailOrderReason(Integer failOrderReason) {
		this.failOrderReason = failOrderReason;
	}
	public String getFailDesc() {
		return failDesc;
	}
	public void setFailDesc(String failDesc) {
		this.failDesc = failDesc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
