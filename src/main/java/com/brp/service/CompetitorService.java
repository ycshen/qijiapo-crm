package com.brp.service;

import java.util.List;

import com.brp.entity.CompetitorEntity;
import com.brp.util.query.CompetitorQuery;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CompetitorService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface CompetitorService {
	void insertCompetitor(CompetitorEntity competitor);
	CompetitorQuery getCompetitorPage(CompetitorQuery competitorQuery);
	CompetitorEntity getCompetitorById(String id);
	void deleteCompetitorById(String id);
	void batchDeleteCompetitor(List<String> idList);
}

