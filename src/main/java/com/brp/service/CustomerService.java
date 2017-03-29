package com.brp.service;

import com.brp.entity.CustomerEntity;
import com.brp.util.query.CustomerQuery;

import java.util.List;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CustomerService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface CustomerService {
	void insertCustomer(CustomerEntity customer);
	void updateCustomer(CustomerEntity customer);
	CustomerQuery getCustomerPage(CustomerQuery customerQuery);
	CustomerEntity getCustomerById(String id);
	void deleteCustomerById(String id);
	void batchDeleteCustomer(List<String> idList);
	Integer getSelfCustomerCount(CustomerQuery customerQuery);
}

