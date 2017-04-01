package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.SalesOppoProductEntity;
import com.brp.service.CompanyService;
import com.brp.service.SalesOppoProductService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: SalesOppoProductApi.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2017 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api-crm/sop")
public class SalesOppoProductApi {
	
	@Autowired
	private SalesOppoProductService sopService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/insertSop", method = RequestMethod.POST)
	@ResponseBody
	public String insertSop(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String sop = jsonObject.getString("sop");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretByCid(cId);
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("sop", sop);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					auth = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(auth && StringUtils.isNotBlank(sop)){
				SalesOppoProductEntity sopObj = JSONObject.parseObject(sop, SalesOppoProductEntity.class);
				sopObj.setIsDelete(0);
				sopObj.setCreateTime(new Date());
				String id = UUID.randomUUID().toString().replaceAll("-", "");
				sopObj.setId(id);
				sopService.insertSalesOppoProduct(sopObj);
				jsonData.setData(id);
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

	@RequestMapping(value = "/getSopBySaleOppoId", method = RequestMethod.POST)
	@ResponseBody
	public String getSopBySaleOppoId(@RequestBody JSONObject jsonObject){
		JsonData<List<SalesOppoProductEntity>> jsonData = new JsonData<List<SalesOppoProductEntity>>();
		try{
			String saleOppoId = jsonObject.getString("saleOppoId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");

			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretByCid(cId);
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("saleOppoId", saleOppoId);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					if(StringUtils.isNotBlank(saleOppoId)){
						List<SalesOppoProductEntity> list = sopService.getSopListBySaleOppoId(saleOppoId);
						jsonData.setData(list);
						jsonData.setCode(ApiCode.OK);
						jsonData.setMessage("操作成功");
					}else{
						jsonData.setCode(ApiCode.ARGS_EXCEPTION);
						jsonData.setMessage("参数异常");
					}
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
					return JsonUtils.json2Str(jsonData);
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
				return JsonUtils.json2Str(jsonData);
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

