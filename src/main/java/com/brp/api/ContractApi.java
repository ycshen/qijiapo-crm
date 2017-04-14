package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.ContractEntity;
import com.brp.service.CompanyService;
import com.brp.service.ContractService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.ContractQuery;
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
 * <p>Title: ContractApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api-crm/contract")
public class ContractApi {
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/insertContract", method = RequestMethod.POST)
	@ResponseBody
	public String insertContract(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String contract = jsonObject.getString("contract");
			if(StringUtils.isNotBlank(contract)){
				ContractEntity contractObj = JSONObject.parseObject(contract, ContractEntity.class);
				contractObj.setIsDelete(0);
				contractObj.setReturnMoneyState(0);
				contractService.insertContract(contractObj);
				jsonData.setData(contractObj.getId().toString());
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
	
	@RequestMapping(value = "/getContractPage", method = RequestMethod.POST)
	@ResponseBody
	public String getContractPage(@RequestBody JSONObject jsonObject){
		JsonData<List<ContractEntity>> jsonData = new JsonData<List<ContractEntity>>();

		try{
			String query = jsonObject.getString("query");
			ContractQuery contractQuery = JSONObject.parseObject(query, ContractQuery.class);
			String roleTypeStr = contractQuery.getRoleType();
			if(StringUtils.isBlank(roleTypeStr)){
				roleTypeStr = "3";
				contractQuery.setRoleType(roleTypeStr);
			}

			Integer page =  contractQuery.getPage();
			if(page == null){
				contractQuery.setPage(1);
			}

			Integer size =  contractQuery.getSize();
			if(size == null){
				contractQuery.setSize(10);
			}

			contractQuery = contractService.getContractPage(contractQuery);
			jsonData.setCode(ApiCode.OK);
			jsonData.setMessage("操作成功");
			jsonData.setData(contractQuery.getItems());
			jsonData.setCount(contractQuery.getCount());

		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
	@RequestMapping(value = "/getContractById", method = RequestMethod.POST)
	@ResponseBody
	public String getContractById(@RequestBody JSONObject jsonObject){
		JsonData<ContractEntity> jsonData = new JsonData<ContractEntity>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				ContractEntity contract = contractService.getContractById(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(contract);
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
	
	@RequestMapping(value = "/deleteContractById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteContractById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				contractService.deleteContractById(id);
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
	
	
	@RequestMapping(value = "/batchDeleteContract", method = RequestMethod.POST)
	@ResponseBody
	public String batchDeleteContract(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String idList = jsonObject.getString("idList");
			if(StringUtils.isNotBlank(idList)){
				List<String> list = JSONObject.parseArray(idList, String.class);
				contractService.batchDeleteContract(list);
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
	
	@RequestMapping(value = "/updateContract", method = RequestMethod.POST)
	@ResponseBody
	public String updateContract(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String contract = jsonObject.getString("contract");
			if(StringUtils.isNotBlank(contract)){
				ContractEntity contractObj = JSONObject.parseObject(contract, ContractEntity.class);
				contractObj.setIsDelete(0);
				contractObj.setUpdateTime(new Date());
				contractService.updateContract(contractObj);
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

	@RequestMapping(value = "/updateReturnMoneyById", method = RequestMethod.POST)
	@ResponseBody
	public String updateSaleMoneyById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String returnMoney = jsonObject.getString("returnMoney");
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && StringUtils.isNotBlank(returnMoney)){
				contractService.updateSaleMoneyById(id, returnMoney);
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

