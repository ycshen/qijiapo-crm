package com.brp.service.impl;

import com.brp.entity.SalesOppoProductEntity;
import com.brp.mapper.SalesOppoProductMapper;
import com.brp.service.SalesOppoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	private SalesOppoProductMapper sopMapper;


	@Override
	public void insertSalesOppoProduct(SalesOppoProductEntity sop) {
		sopMapper.insertSalesOppoProduct(sop);
	}

	@Override
	public List<SalesOppoProductEntity> getSopListBySaleOppoId(String saleOppoId) {
		return sopMapper.getSopListBySaleOppoId(saleOppoId);
	}
}

