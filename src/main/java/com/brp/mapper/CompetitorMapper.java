package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.CompetitorEntity;
import com.brp.util.query.CompetitorQuery;

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
	List<CompetitorEntity> getCompetitorPage(CompetitorQuery competitorQuery);
}

