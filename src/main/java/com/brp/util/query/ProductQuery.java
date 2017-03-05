package com.brp.util.query;

import com.brp.entity.ProductEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CompetitorQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class ProductQuery extends Page<ProductEntity>{
	
	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}

