package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.CompetitorEntity;
import com.brp.service.CompanyService;
import com.brp.service.CompetitorService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.CompetitorQuery;
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
@RequestMapping("/api-crm/competitor")
public class CompetitorApi {
	
	@Autowired
	private CompetitorService competitorService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/insertCompetitor", method = RequestMethod.POST)
	@ResponseBody
	public String insertCompetitor(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String competitor = jsonObject.getString("competitor");
			if(StringUtils.isNotBlank(competitor)){
				CompetitorEntity competitorObj = JSONObject.parseObject(competitor, CompetitorEntity.class);
				competitorObj.setIsDelete(0);
				competitorService.insertCompetitor(competitorObj);
				jsonData.setData(competitorObj.getId().toString());
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
	
	@RequestMapping(value = "/getCompetitorPage", method = RequestMethod.POST)
	@ResponseBody
	public String getCompetitorPage(@RequestBody JSONObject jsonObject){
		JsonData<List<CompetitorEntity>> jsonData = new JsonData<List<CompetitorEntity>>();
		try{
			String query = jsonObject.getString("query");
			if(StringUtils.isNotBlank(query)){
				CompetitorQuery competitorQuery = JSONObject.parseObject(query, CompetitorQuery.class);
				String roleTypeStr = competitorQuery.getRoleType();
				if(StringUtils.isBlank(roleTypeStr)){
					roleTypeStr = "3";
					competitorQuery.setRoleType(roleTypeStr);
				}
				
				Integer page =  competitorQuery.getPage();
				if(page == null){
					competitorQuery.setPage(1);
				}
				
				Integer size =  competitorQuery.getSize();
				if(size == null){
					competitorQuery.setSize(10);
				}
				
				competitorQuery = competitorService.getCompetitorPage(competitorQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(competitorQuery.getItems());
				jsonData.setCount(competitorQuery.getCount());
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
	
	@RequestMapping(value = "/getCompetitorById", method = RequestMethod.POST)
	@ResponseBody
	public String getCompetitorById(@RequestBody JSONObject jsonObject){
		JsonData<CompetitorEntity> jsonData = new JsonData<CompetitorEntity>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				CompetitorEntity competitor = competitorService.getCompetitorById(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(competitor);
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
	
	@RequestMapping(value = "/deleteCompetitorById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCompetitorById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				competitorService.deleteCompetitorById(id);
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
	
	
	@RequestMapping(value = "/batchDeleteCompetitor", method = RequestMethod.POST)
	@ResponseBody
	public String batchDeleteCompetitor(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String idList = jsonObject.getString("idList");
			if(StringUtils.isNotBlank(idList)){
				List<String> list = JSONObject.parseArray(idList, String.class);
				competitorService.batchDeleteCompetitor(list);
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
	
	@RequestMapping(value = "/updateCompetitor", method = RequestMethod.POST)
	@ResponseBody
	public String updateCompetitor(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String competitor = jsonObject.getString("competitor");
			if(StringUtils.isNotBlank(competitor)){
				CompetitorEntity competitorObj = JSONObject.parseObject(competitor, CompetitorEntity.class);
				competitorObj.setIsDelete(0);
				competitorObj.setUpdateTime(new Date());
				competitorService.updateCompetitor(competitorObj);
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

