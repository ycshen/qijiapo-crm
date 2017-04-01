package com.brp.service.impl;

import com.brp.entity.SalesOpportunityEntity;
import com.brp.mapper.SalesOpportunityMapper;
import com.brp.service.SalesOpportunityService;
import com.brp.util.query.SalesOpportunityQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOpportunityServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class SalesOpportunityServiceImpl implements SalesOpportunityService{
	@Autowired
	private SalesOpportunityMapper salesOpportunityMapper;

	@Override
	public void insertSalesOpportunity(SalesOpportunityEntity salesOpportunity) {
		salesOpportunityMapper.insertSalesOpportunity(salesOpportunity);
	}

	@Override
	public SalesOpportunityQuery getSalesOpportunityPage(SalesOpportunityQuery salesOpportunityQuery) {
		List<SalesOpportunityEntity> list = salesOpportunityMapper.getSalesOpportunityPage(salesOpportunityQuery);
		if(list != null && list.size() > 0){
			salesOpportunityQuery.setItems(list);
		}
		
		
		return salesOpportunityQuery;
	}

	@Override
	public SalesOpportunityEntity getSalesOpportunityById(String id) {
		return salesOpportunityMapper.getSalesOpportunityById(id);
	}

	@Override
	public void deleteSalesOpportunityById(String id) {
		salesOpportunityMapper.deleteSalesOpportunityById(id);
	}

	@Override
	public void batchDeleteSalesOpportunity(List<String> idList) {
		if(idList != null && idList.size() > 0){
			String inId = "";
			for (String id : idList) {
				inId += id + ",";
			}
			
			if(StringUtils.isNotBlank(inId)){
				inId = inId.substring(0, inId.length() - 1);
				salesOpportunityMapper.batchDeleteSalesOpportunity(inId);
			}
		}
	}

	@Override
	public void updateSalesOpportunity(SalesOpportunityEntity salesOpportunity) {
		salesOpportunityMapper.updateSalesOpportunity(salesOpportunity);
	}

	@Override
	public void updateSaleMoneyById(String id, String saleMoney) {
		salesOpportunityMapper.updateSaleMoneyById(id, saleMoney);
	}
}

