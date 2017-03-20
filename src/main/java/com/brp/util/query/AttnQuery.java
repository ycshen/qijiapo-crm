package com.brp.util.query;

import com.brp.entity.AttnEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/3/2.
 */
public class AttnQuery extends Page<AttnEntity> {

    private String cityId;
    private String areaId;
    private String attnName;
    private String provinceId;

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

    public String getAttnName() {
        return attnName;
    }

    public void setAttnName(String attnName) {
        this.attnName = attnName;
    }
}
