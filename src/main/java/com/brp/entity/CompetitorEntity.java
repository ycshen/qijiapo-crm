package com.brp.entity;
/**
 * 竞争对手
 * @author Administrator
 *
 */
public class CompetitorEntity extends BaseEntity{
	private String competitorName; //竞争对手名称
	private String beyondUser; //竞争对手所有人
	private String beyondUserType; //竞争对手类型 1-个人 2-团队or部门 3-公司
	private String address;
	private String website; //公司网址
	private Integer staffNum; //员工数量
	private String saleMoney; //公司销售额
	private String postcode; //邮编
	private String mobile; //电话
	private String beyondOf; //所属人
	public String getCompetitorName() {
		return competitorName;
	}
	public void setCompetitorName(String competitorName) {
		this.competitorName = competitorName;
	}
	public String getBeyondUser() {
		return beyondUser;
	}
	public void setBeyondUser(String beyondUser) {
		this.beyondUser = beyondUser;
	}
	public String getBeyondUserType() {
		return beyondUserType;
	}
	public void setBeyondUserType(String beyondUserType) {
		this.beyondUserType = beyondUserType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Integer getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(Integer staffNum) {
		this.staffNum = staffNum;
	}
	public String getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(String saleMoney) {
		this.saleMoney = saleMoney;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBeyondOf() {
		return beyondOf;
	}
	public void setBeyondOf(String beyondOf) {
		this.beyondOf = beyondOf;
	}
	
}
