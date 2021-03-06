package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.SalesOpportunityEntity;
import com.brp.service.CompanyService;
import com.brp.service.SalesOpportunityService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.SalesOpportunityQuery;
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
 * <p>Title: SalesOpportunityApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api-crm/salesOpportunity")
public class SalesOpportunityApi {
	
	@Autowired
	private SalesOpportunityService salesOpportunityService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/insertSalesOpportunity", method = RequestMethod.POST)
	@ResponseBody
	public String insertSalesOpportunity(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String salesOpportunity = jsonObject.getString("salesOpportunity");
			if(StringUtils.isNotBlank(salesOpportunity)){
				SalesOpportunityEntity salesOpportunityObj = JSONObject.parseObject(salesOpportunity, SalesOpportunityEntity.class);
				salesOpportunityObj.setIsDelete(0);
				salesOpportunityService.insertSalesOpportunity(salesOpportunityObj);
				jsonData.setData(salesOpportunityObj.getId().toString());
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
	
	@RequestMapping(value = "/getSalesOpportunityPage", method = RequestMethod.POST)
	@ResponseBody
	public String getSalesOpportunityPage(@RequestBody JSONObject jsonObject){
		JsonData<List<SalesOpportunityEntity>> jsonData = new JsonData<List<SalesOpportunityEntity>>();
		try{
			String query = jsonObject.getString("query");
			if(StringUtils.isNotBlank(query)){
				SalesOpportunityQuery salesOpportunityQuery = JSONObject.parseObject(query, SalesOpportunityQuery.class);
				String roleTypeStr = salesOpportunityQuery.getRoleType();
				if(StringUtils.isBlank(roleTypeStr)){
					roleTypeStr = "3";
					salesOpportunityQuery.setRoleType(roleTypeStr);
				}
				
				Integer page =  salesOpportunityQuery.getPage();
				if(page == null){
					salesOpportunityQuery.setPage(1);
				}
				
				Integer size =  salesOpportunityQuery.getSize();
				if(size == null){
					salesOpportunityQuery.setSize(10);
				}
				
				salesOpportunityQuery = salesOpportunityService.getSalesOpportunityPage(salesOpportunityQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(salesOpportunityQuery.getItems());
				jsonData.setCount(salesOpportunityQuery.getCount());
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
	
	@RequestMapping(value = "/getSalesOpportunityById", method = RequestMethod.POST)
	@ResponseBody
	public String getSalesOpportunityById(@RequestBody JSONObject jsonObject){
		JsonData<SalesOpportunityEntity> jsonData = new JsonData<SalesOpportunityEntity>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				SalesOpportunityEntity salesOpportunity = salesOpportunityService.getSalesOpportunityById(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(salesOpportunity);
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
	
	@RequestMapping(value = "/deleteSalesOpportunityById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteSalesOpportunityById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				salesOpportunityService.deleteSalesOpportunityById(id);
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
	
	
	@RequestMapping(value = "/batchDeleteSalesOpportunity", method = RequestMethod.POST)
	@ResponseBody
	public String batchDeleteSalesOpportunity(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String idList = jsonObject.getString("idList");
			if(StringUtils.isNotBlank(idList)){
				List<String> list = JSONObject.parseArray(idList, String.class);
				salesOpportunityService.batchDeleteSalesOpportunity(list);
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
	
	@RequestMapping(value = "/updateSalesOpportunity", method = RequestMethod.POST)
	@ResponseBody
	public String updateSalesOpportunity(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String salesOpportunity = jsonObject.getString("salesOpportunity");
			if(StringUtils.isNotBlank(salesOpportunity)){
				SalesOpportunityEntity salesOpportunityObj = JSONObject.parseObject(salesOpportunity, SalesOpportunityEntity.class);
				salesOpportunityObj.setIsDelete(0);
				salesOpportunityObj.setUpdateTime(new Date());
				salesOpportunityService.updateSalesOpportunity(salesOpportunityObj);
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


	@RequestMapping(value = "/updateSaleMoneyById", method = RequestMethod.POST)
	@ResponseBody
	public String updateSaleMoneyById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String saleMoney = jsonObject.getString("saleMoney");
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && StringUtils.isNotBlank(saleMoney)){
				salesOpportunityService.updateSaleMoneyById(id, saleMoney);
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

