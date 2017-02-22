package com.brp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.CompetitorEntity;
import com.brp.mapper.CompetitorMapper;
import com.brp.service.CompetitorService;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CustomerServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class CompetitorServiceImpl implements CompetitorService{
	@Autowired
	private CompetitorMapper competitorMapper;

	@Override
	public void insertCompetitor(CompetitorEntity competitor) {
		competitorMapper.insertCompetitor(competitor);
	}

	
	

	
	
}

