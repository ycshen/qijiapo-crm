package com.brp.entity;

import java.util.Date;

/**
 * Created by fengyue on 7/4/.
 */
public class WorkAttendanceEntity {
    private Long id;

    private String userId;

    private String userName;

    private String createUserId;
    private String createUser;
    private String departmentId;
    private String departmentName;
    private String location;
    private Date attendanceTime;
    private Integer state;//签到状态（0正常，1迟到，2早退）
    private String lateCause;
    private String leaveEarlyReason;
    private String onWorkAttendanceLocation;
    private String offWorkAttendanceLocation;
    private Date onWorkTime;
    private Date offWorkTime;
    private Date createTime;
    private String companyId;
    private String companyName;
    private Integer isDelete;
    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLateCause() {
        return lateCause;
    }

    public void setLateCause(String lateCause) {
        this.lateCause = lateCause;
    }

    public String getLeaveEarlyReason() {
        return leaveEarlyReason;
    }

    public void setLeaveEarlyReason(String leaveEarlyReason) {
        this.leaveEarlyReason = leaveEarlyReason;
    }

    public String getOnWorkAttendanceLocation() {
        return onWorkAttendanceLocation;
    }

    public void setOnWorkAttendanceLocation(String onWorkAttendanceLocation) {
        this.onWorkAttendanceLocation = onWorkAttendanceLocation;
    }

    public String getOffWorkAttendanceLocation() {
        return offWorkAttendanceLocation;
    }

    public void setOffWorkAttendanceLocation(String offWorkAttendanceLocation) {
        this.offWorkAttendanceLocation = offWorkAttendanceLocation;
    }

    public Date getOnWorkTime() {
        return onWorkTime;
    }

    public void setOnWorkTime(Date onWorkTime) {
        this.onWorkTime = onWorkTime;
    }

    public Date getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(Date offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
