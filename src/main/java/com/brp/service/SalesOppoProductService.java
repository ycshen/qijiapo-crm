package com.brp.service;

import com.brp.entity.SalesOppoProductEntity;

import java.util.List;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOpportunityService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface SalesOppoProductService {
	void insertSalesOppoProduct(SalesOppoProductEntity sop);
	List<SalesOppoProductEntity> getSopListBySaleOppoId(String saleOppoId);
	void deleteSopById(String id);
}

