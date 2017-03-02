package com.brp.util.query;

import com.brp.entity.AttnEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/3/2.
 */
public class AttnQuery extends Page<AttnEntity> {

    private String cityId;
    private String areaId;
    private String competitorName;

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
