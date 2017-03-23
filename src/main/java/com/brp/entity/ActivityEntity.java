package com.brp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by fengyue on 2017/3/22.
 */
public class ActivityEntity extends BaseEntity{
    private int activityType;//活动类型
    private int activityState;//活动状态
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityStartTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityEndTime;//结束时间
    private int invitationPopulation;//邀请人数
    private int realNum;//时间人数
    private int businessType;//业务类型
    private String activityNote;//业务说明
    private double activityCost;//活动成本
    private double expectedIncome;//预计收入
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;//活动最新记录时间
    private int expectedNum;//预计响应
    private double realActivityCost;//实际成本
    private double realIncome;//实际收入
    private String activityName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public int getActivityState() {
        return activityState;
    }

    public void setActivityState(int activityState) {
        this.activityState = activityState;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public int getInvitationPopulation() {
        return invitationPopulation;
    }

    public void setInvitationPopulation(int invitationPopulation) {
        this.invitationPopulation = invitationPopulation;
    }

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public String getActivityNote() {
        return activityNote;
    }

    public void setActivityNote(String activityNote) {
        this.activityNote = activityNote;
    }

    public double getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(double activityCost) {
        this.activityCost = activityCost;
    }

    public double getExpectedIncome() {
        return expectedIncome;
    }

    public void setExpectedIncome(double expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public int getExpectedNum() {
        return expectedNum;
    }

    public void setExpectedNum(int expectedNum) {
        this.expectedNum = expectedNum;
    }

    public double getRealActivityCost() {
        return realActivityCost;
    }

    public void setRealActivityCost(double realActivityCost) {
        this.realActivityCost = realActivityCost;
    }

    public double getRealIncome() {
        return realIncome;
    }

    public void setRealIncome(double realIncome) {
        this.realIncome = realIncome;
    }
}
