package com.brp.service;

import java.util.List;

import com.brp.entity.ProductEntity;
import com.brp.util.query.ProductQuery;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: ProductService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface ProductService {
	void insertProduct(ProductEntity product);
	void updateProduct(ProductEntity product);
	ProductQuery getProductPage(ProductQuery productQuery);
	ProductEntity getProductById(String id);
	void deleteProductById(String id);
	void batchDeleteProduct(List<String> idList);
}

