package com.brp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brp.entity.PositionEntity;
import com.brp.service.PositionService;
import com.brp.util.query.PositionQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class PositionServiceImpl implements PositionService{

	@Override
	public void insertPosition(PositionEntity position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PositionEntity> getPositionList(PositionQuery positionQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePosition(PositionEntity position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PositionEntity getPositionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePositionById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PositionEntity getPositionByQuery(PositionQuery positionQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PositionQuery getPositionPage(PositionQuery positionQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PositionEntity getPositionByIdWithoutIsdelete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

