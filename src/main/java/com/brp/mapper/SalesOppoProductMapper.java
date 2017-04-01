package com.brp.mapper;

import com.brp.entity.SalesOppoProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOppoSalesOppoProductMapper.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2017xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface SalesOppoProductMapper {
	void insertSalesOppoProduct(SalesOppoProductEntity sop);
	List<SalesOppoProductEntity> getSopListBySaleOppoId(String saleOppoId);
}

