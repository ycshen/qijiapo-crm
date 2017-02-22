package com.brp.mapper;

import org.springframework.stereotype.Repository;

import com.brp.entity.CompetitorEntity;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CompetitorMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface CompetitorMapper {
	void insertCompetitor(CompetitorEntity competitor);
}

