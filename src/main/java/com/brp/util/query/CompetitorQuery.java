package com.brp.util.query;

import com.brp.entity.CompetitorEntity;
import com.brp.entity.PositionEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: qijiapo-crm</p> 
 * <p>Title: CompetitorQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class CompetitorQuery extends Page<CompetitorEntity>{
	
	private String provinceId;
	private String cityId;
	private String areaId;
	private String competitorName;
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getCompetitorName() {
		return competitorName;
	}
	public void setCompetitorName(String competitorName) {
		this.competitorName = competitorName;
	}
	
}

