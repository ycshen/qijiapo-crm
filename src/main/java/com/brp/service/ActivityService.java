package com.brp.service;

import com.brp.entity.ActivityEntity;
import com.brp.util.query.ActivityQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/3/22.
 */
public interface ActivityService {
    void insertActivity(ActivityEntity activity);
    void updateActivity(ActivityEntity activity);
    ActivityQuery getActivityPage(ActivityQuery activityQuery);
    ActivityEntity getActivityById(String id);
    void deleteActivityById(String id);
    void batchDeleteActivity(List<String> idList);
}
