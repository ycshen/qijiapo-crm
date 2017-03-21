package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.SalesOpportunityEntity;
import com.brp.util.query.SalesOpportunityQuery;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOpportunityMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface SalesOpportunityMapper {
	void insertSalesOpportunity(SalesOpportunityEntity salesOpportunity);
	List<SalesOpportunityEntity> getSalesOpportunityPage(SalesOpportunityQuery salesOpportunityQuery);
	SalesOpportunityEntity getSalesOpportunityById(String id);
	void deleteSalesOpportunityById(String id);
	void batchDeleteSalesOpportunity(@Param("inId")String inId);
	void updateSalesOpportunity(SalesOpportunityEntity salesOpportunity);
}

