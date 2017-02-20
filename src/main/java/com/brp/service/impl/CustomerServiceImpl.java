package com.brp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.CustomerEntity;
import com.brp.mapper.CustomerMapper;
import com.brp.service.CustomerService;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CustomerServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public void insertCustomer(CustomerEntity customer) {
		customerMapper.insertCustomer(customer);
	}

	
	
}

