package com.brp.service.impl;

import com.brp.entity.CustomerEntity;
import com.brp.mapper.CustomerMapper;
import com.brp.service.CustomerService;
import com.brp.util.query.CustomerQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public CustomerQuery getCustomerPage(CustomerQuery customerQuery) {
		List<CustomerEntity> list = customerMapper.getCustomerPage(customerQuery);
		if(list != null && list.size() > 0){
			customerQuery.setItems(list);
		}
		
		
		return customerQuery;
	}

	@Override
	public CustomerEntity getCustomerById(String id) {
		return customerMapper.getCustomerById(id);
	}

	@Override
	public void deleteCustomerById(String id) {
		customerMapper.deleteCustomerById(id);
	}

	@Override
	public void batchDeleteCustomer(List<String> idList) {
		if(idList != null && idList.size() > 0){
			String inId = "";
			for (String id : idList) {
				inId += id + ",";
			}
			
			if(StringUtils.isNotBlank(inId)){
				inId = inId.substring(0, inId.length() - 1);
				customerMapper.batchDeleteCustomer(inId);
			}
		}
	}

	@Override
	public void updateCustomer(CustomerEntity customer) {
		customerMapper.updateCustomer(customer);
	}


	@Override
	public Integer getSelfCustomerCount(CustomerQuery customerQuery) {
		return customerMapper.getSelfCustomerCount(customerQuery);
	}
}

