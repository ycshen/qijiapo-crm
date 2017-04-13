package com.brp.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.ProductEntity;
import com.brp.mapper.ProductMapper;
import com.brp.service.ProductService;
import com.brp.util.query.ProductQuery;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: ProductServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void insertProduct(ProductEntity product) {
		productMapper.insertProduct(product);
	}

	@Override
	public ProductQuery getProductPage(ProductQuery productQuery) {
		List<ProductEntity> list = productMapper.getProductPage(productQuery);
		if(list != null && list.size() > 0){
			productQuery.setItems(list);
		}
		
		
		return productQuery;
	}

	@Override
	public ProductEntity getProductById(String id) {
		return productMapper.getProductById(id);
	}

	@Override
	public void deleteProductById(String id) {
		productMapper.deleteProductById(id);
	}

	@Override
	public void batchDeleteProduct(List<String> idList) {
		if(idList != null && idList.size() > 0){
			String inId = "";
			for (String id : idList) {
				inId += id + ",";
			}
			
			if(StringUtils.isNotBlank(inId)){
				inId = inId.substring(0, inId.length() - 1);
				productMapper.batchDeleteProduct(inId);
			}
		}
	}

	@Override
	public void updateProduct(ProductEntity product) {
		productMapper.updateProduct(product);
	}

	
	

	
	
}

