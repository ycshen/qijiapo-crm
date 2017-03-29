package com.brp.entity;

import java.util.Date;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/29
 * @Desc qijiapo-crm-com.brp.entity
 */
public class SalesOppoProductEntity {
    private String id;
    private String salesOppoId; //销售机会id
    private String productId; //产品id
    private Integer saleNum; //销售数量
    private String discount; //折扣
    private String remark;
    private Date createTime;
    private String userId;
    private String userName;
    private Integer isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalesOppoId() {
        return salesOppoId;
    }

    public void setSalesOppoId(String salesOppoId) {
        this.salesOppoId = salesOppoId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
