package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.ProductEntity;
import com.brp.service.CompanyService;
import com.brp.service.ProductService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.ProductQuery;
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
 * <p>Title: ProductApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api-crm/product")
public class ProductApi {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	@ResponseBody
	public String insertProduct(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String product = jsonObject.getString("product");
			if(StringUtils.isNotBlank(product)){
				ProductEntity productObj = JSONObject.parseObject(product, ProductEntity.class);
				productObj.setIsDelete(0);
				productService.insertProduct(productObj);
				jsonData.setData(productObj.getId().toString());
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
	
	@RequestMapping(value = "/getProductPage", method = RequestMethod.POST)
	@ResponseBody
	public String getProductPage(@RequestBody JSONObject jsonObject){
		JsonData<List<ProductEntity>> jsonData = new JsonData<List<ProductEntity>>();
		try{
			String query = jsonObject.getString("query");
			if(StringUtils.isNotBlank(query)){
				ProductQuery productQuery = JSONObject.parseObject(query, ProductQuery.class);
				String roleTypeStr = productQuery.getRoleType();
				if(StringUtils.isBlank(roleTypeStr)){
					roleTypeStr = "3";
					productQuery.setRoleType(roleTypeStr);
				}
				
				Integer page =  productQuery.getPage();
				if(page == null){
					productQuery.setPage(1);
				}
				
				Integer size =  productQuery.getSize();
				if(size == null){
					productQuery.setSize(10);
				}
				
				productQuery = productService.getProductPage(productQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(productQuery.getItems());
				jsonData.setCount(productQuery.getCount());
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
	
	@RequestMapping(value = "/getProductById", method = RequestMethod.POST)
	@ResponseBody
	public String getProductById(@RequestBody JSONObject jsonObject){
		JsonData<ProductEntity> jsonData = new JsonData<ProductEntity>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				ProductEntity product = productService.getProductById(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(product);
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
	
	@RequestMapping(value = "/deleteProductById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteProductById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String id = jsonObject.getString("id");
			if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				
				productService.deleteProductById(id);
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
	
	
	@RequestMapping(value = "/batchDeleteProduct", method = RequestMethod.POST)
	@ResponseBody
	public String batchDeleteProduct(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String idList = jsonObject.getString("idList");
			if(StringUtils.isNotBlank(idList)){
				List<String> list = JSONObject.parseArray(idList, String.class);
				productService.batchDeleteProduct(list);
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
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	@ResponseBody
	public String updateProduct(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String product = jsonObject.getString("product");
			if(StringUtils.isNotBlank(product)){
				ProductEntity productObj = JSONObject.parseObject(product, ProductEntity.class);
				productObj.setIsDelete(0);
				productObj.setUpdateTime(new Date());
				productService.updateProduct(productObj);
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

