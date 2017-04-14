package com.brp.util.query;

import com.brp.entity.WorkAttendancePlaceEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/4/11.
 */
public class WorkAttendancePlaceQuery extends Page<WorkAttendancePlaceEntity> {

    private Long id;

    private String placeName;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
