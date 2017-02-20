package com.brp.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.brp.service.CompanyService;
import com.brp.util.api.MyBaseApiUtils;
import com.brp.util.api.model.ApiCode;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class CompanyServiceImpl implements CompanyService{

	@Override
	public String getSecretByCid(String cid) {
		String result = MyBaseApiUtils.getSecretById(cid);
		String secret = StringUtils.EMPTY;
		if(StringUtils.isNotBlank(result)){
			JSONObject jsonObject = JSONObject.parseObject(result);
			if(jsonObject != null){
				Object codeObj = jsonObject.get("code");
				if(codeObj != null){
					String code = codeObj.toString();
					if (ApiCode.OK.toString().equals(code)) {
						Object dataObj = jsonObject.get("data");
						if(dataObj != null){
							secret = dataObj.toString();
						}
					}
				}
			}
		}
		
		return secret;
	}
	
	
}

