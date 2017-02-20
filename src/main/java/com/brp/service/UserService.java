package com.brp.service;

import com.brp.entity.UserEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface UserService {
	UserEntity login(String account, String password);
	
}

