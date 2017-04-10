package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.CustomerEntity;
import com.brp.service.CompanyService;
import com.brp.service.CustomerService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.CustomerQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CustomerApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api-crm/customer")
public class CustomerApi {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
	@ResponseBody
	public String insertCustomer(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String customer = jsonObject.getString("customer");
			if(StringUtils.isNotBlank(customer)){
				CustomerEntity customerObj = JSONObject.parseObject(customer, CustomerEntity.class);
				customerObj.setIsDelete(0);
				customerService.insertCustomer(customerObj);
				jsonData.setData(customerObj.getId().toString());
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
	@RequestMapping(value = "/getCustomerPage", method = RequestMethod.POST)
	@ResponseBody
	public String getCustomerPage(@RequestBody JSONObject jsonObject){
		JsonData<List<CustomerEntity>> jsonData = new JsonData<List<CustomerEntity>>();
		try{
			String query = jsonObject.getString("query");
			if(StringUtils.isNotBlank(query)){
				CustomerQuery customerQuery = JSONObject.parseObject(query, CustomerQuery.class);
				String roleTypeStr = customerQuery.getRoleType();
				if(StringUtils.isBlank(roleTypeStr)){
					roleTypeStr = "3";
					customerQuery.setRoleType(roleTypeStr);
				}
				
				String customerName = customerQuery.getCustomerName();
				if(StringUtils.isNotBlank(customerName)){
					customerQuery.setCustomerName("%" + customerName.replaceAll(" ", "") + "%");
				}
				Integer page =  customerQuery.getPage();
				if(page == null){
					customerQuery.setPage(1);
				}
				
				Integer size =  customerQuery.getSize();
				if(size == null){
					customerQuery.setSize(10);
				}
				
				customerQuery = customerService.getCustomerPage(customerQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(customerQuery.getItems());
				jsonData.setCount(customerQuery.getCount());
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}

	@RequestMapping(value = "/getSelfCustomerCount", method = RequestMethod.POST)
	@ResponseBody
	public String getSelfCustomerCount(@RequestBody JSONObject jsonObject){
		JsonData<Integer> jsonData = new JsonData<Integer>();
		try{
			String query = jsonObject.getString("query");
			if(StringUtils.isNotBlank(query)){
				CustomerQuery customerQuery = JSONObject.parseObject(query, CustomerQuery.class);
				String roleTypeStr = customerQuery.getRoleType();
				if(StringUtils.isBlank(roleTypeStr)){
					roleTypeStr = "3";
					customerQuery.setRoleType(roleTypeStr);
				}


				Integer count = customerService.getSelfCustomerCount(customerQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(count);
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}

		String result = JsonUtils.json2Str(jsonData);

		return result;
	}
	
	@RequestMapping(value = "/getCustomerById", method = RequestMethod.POST)
	@ResponseBody
	public String getCustomerById(@RequestBody JSONObject jsonObject){
		JsonData<CustomerEntity> jsonData = new JsonData<CustomerEntity>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				CustomerEntity customer = customerService.getCustomerById(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(customer);
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
	@RequestMapping(value = "/deleteCustomerById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCustomerById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				customerService.deleteCustomerById(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
	
	@RequestMapping(value = "/batchDeleteCustomer", method = RequestMethod.POST)
	@ResponseBody
	public String batchDeleteCustomer(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String idList = jsonObject.getString("idList");
			if(StringUtils.isNotBlank(idList)){
				List<String> list = JSONObject.parseArray(idList, String.class);
				customerService.batchDeleteCustomer(list);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	@ResponseBody
	public String updateCustomer(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String customer = jsonObject.getString("customer");
			if(StringUtils.isNotBlank(customer)){
				CustomerEntity customerObj = JSONObject.parseObject(customer, CustomerEntity.class);
				customerObj.setIsDelete(0);
				customerObj.setUpdateTime(new Date());
				customerService.updateCustomer(customerObj);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
}

