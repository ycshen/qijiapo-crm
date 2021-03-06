package com.brp.mapper;

import com.brp.entity.CustomerEntity;
import com.brp.util.query.CustomerQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CustomerMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface CustomerMapper {
	void insertCustomer(CustomerEntity customer);
	List<CustomerEntity> getCustomerPage(CustomerQuery customerQuery);
	CustomerEntity getCustomerById(String id);
	void deleteCustomerById(String id);
	void batchDeleteCustomer(@Param("inId")String inId);
	void updateCustomer(CustomerEntity customer);
	Integer getSelfCustomerCount(CustomerQuery customerQuery);
	List<CustomerEntity> getAllCustomer(String companyId);
}

