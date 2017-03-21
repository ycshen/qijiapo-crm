package com.brp.service;

import java.util.List;

import com.brp.entity.SalesOpportunityEntity;
import com.brp.util.query.SalesOpportunityQuery;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOpportunityService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface SalesOpportunityService {
	void insertSalesOpportunity(SalesOpportunityEntity salesOpportunity);
	void updateSalesOpportunity(SalesOpportunityEntity salesOpportunity);
	SalesOpportunityQuery getSalesOpportunityPage(SalesOpportunityQuery salesOpportunityQuery);
	SalesOpportunityEntity getSalesOpportunityById(String id);
	void deleteSalesOpportunityById(String id);
	void batchDeleteSalesOpportunity(List<String> idList);
}

