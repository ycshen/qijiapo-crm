package com.brp.mapper;

import com.brp.entity.ActivityEntity;
import com.brp.util.query.ActivityQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengyue on 2017/3/22.
 */
public interface ActivityMapper {

    void insertActivity(ActivityEntity attn);
    List<ActivityEntity> getActivityPage(ActivityQuery attnQuery);
    ActivityEntity getActivityById(String id);
    void deleteActivityById(String id);
    void batchDeleteActivity(@Param("inId")String inId);
    void updateActivity(ActivityEntity Activity);
}
