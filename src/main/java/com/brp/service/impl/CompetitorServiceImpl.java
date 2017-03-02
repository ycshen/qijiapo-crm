package com.brp.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.base.RoleEnum;
import com.brp.entity.CompetitorEntity;
import com.brp.mapper.CompetitorMapper;
import com.brp.service.CompetitorService;
import com.brp.util.query.CompetitorQuery;

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

	@Override
	public CompetitorQuery getCompetitorPage(CompetitorQuery competitorQuery) {
		List<CompetitorEntity> list = competitorMapper.getCompetitorPage(competitorQuery);
		if(list != null && list.size() > 0){
			competitorQuery.setItems(list);
		}
		
		
		return competitorQuery;
	}

	@Override
	public CompetitorEntity getCompetitorById(String id) {
		return competitorMapper.getCompetitorById(id);
	}

	@Override
	public void deleteCompetitorById(String id) {
		competitorMapper.deleteCompetitorById(id);
	}

	@Override
	public void batchDeleteCompetitor(List<String> idList) {
		if(idList != null && idList.size() > 0){
			String inId = "";
			for (String id : idList) {
				inId += id + ",";
			}
			
			if(StringUtils.isNotBlank(inId)){
				inId = inId.substring(0, inId.length() - 1);
				competitorMapper.batchDeleteCompetitor(inId);
			}
		}
	}

	@Override
	public void updateCompetitor(CompetitorEntity competitor) {
		competitorMapper.updateCompetitor(competitor);
	}

	
	

	
	
}

