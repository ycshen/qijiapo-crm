package com.brp.base.url;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: Constant.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Component
public class MyBaseApiUrl {
	@Value("${mybase}")
	private String mybase_url;
	public static String mybase;
	//user
	@Value("${mybase.login}")
	private String mybase_login_url;
	public static String mybase_login;
	
	//company
	@Value("${mybase.getSecretById}")
	private String mybase_getSecretById_url;
	public static String mybase_getSecretById;
	
	@PostConstruct
	public void init() {
		mybase_login = this.mybase_login_url;
		//user
		mybase = this.mybase_url;
		
		//company
		mybase_getSecretById = this.mybase_getSecretById_url;
	}
	
}

