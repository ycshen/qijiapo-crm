package com.brp.service.impl;

import com.brp.entity.ActivityEntity;
import com.brp.mapper.ActivityMapper;
import com.brp.service.ActivityService;
import com.brp.util.query.ActivityQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/3/22.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public void insertActivity(ActivityEntity activity) {
        activityMapper.insertActivity(activity);
    }

    @Override
    public void updateActivity(ActivityEntity activity) {
        activityMapper.updateActivity(activity);
    }

    @Override
    public ActivityQuery getActivityPage(ActivityQuery activityQuery) {
        List<ActivityEntity> entities = activityMapper.getActivityPage(activityQuery);
        if (entities != null && entities.size() > 0)
            activityQuery.setItems(entities);
        return activityQuery;
    }

    @Override
    public ActivityEntity getActivityById(String id) {
        return activityMapper.getActivityById(id);
    }

    @Override
    public void deleteActivityById(String id) {
        activityMapper.deleteActivityById(id);
    }

    @Override
    public void batchDeleteActivity(List<String> idList) {
        if(idList != null && idList.size() > 0){
            String inId = "";
            for (String id : idList) {
                inId += id + ",";
            }

            if(StringUtils.isNotBlank(inId)){
                inId = inId.substring(0, inId.length() - 1);
                activityMapper.batchDeleteActivity(inId);
            }
        }
    }
}
