package com.brp.service.impl;

import com.brp.entity.SalesOppoProductEntity;
import com.brp.service.SalesOppoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOppoProductServiceImpl.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class SalesOppoProductServiceImpl implements SalesOppoProductService{
	@Autowired
	private SalesOppoProductService sopService;


	@Override
	public void insertSalesOppoProduct(SalesOppoProductEntity sop) {
		sopService.insertSalesOppoProduct(sop);
	}
}

