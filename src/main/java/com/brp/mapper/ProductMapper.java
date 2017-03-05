package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.ProductEntity;
import com.brp.util.query.ProductQuery;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: ProductMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface ProductMapper {
	void insertProduct(ProductEntity product);
	List<ProductEntity> getProductPage(ProductQuery productQuery);
	ProductEntity getProductById(String id);
	void deleteProductById(String id);
	void batchDeleteProduct(@Param("inId")String inId);
	void updateProduct(ProductEntity product);
}

