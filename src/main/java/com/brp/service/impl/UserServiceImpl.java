package com.brp.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.UserEntity;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.api.MyBaseApiUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.vo.UserAuthVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class UserServiceImpl implements UserService{
	@Override
	public UserEntity login(String account, String password) {
		String loginResult = MyBaseApiUtils.login(account, password);
		UserEntity user = null;
		if(StringUtils.isNotBlank(loginResult)){
			JSONObject jsonObject = JSONObject.parseObject(loginResult);
			if(jsonObject != null){
				Object codeObj = jsonObject.get("code");
				if(codeObj != null){
					String code = codeObj.toString();
					if (ApiCode.OK.toString().equals(code)) {
						Object dataObj = jsonObject.get("data");
						if(dataObj != null){
							String data = dataObj.toString();
							user = JSONObject.parseObject(data, UserEntity.class);
						}
					}
				}
			}
		}
		
		return user;
	}
	
}

