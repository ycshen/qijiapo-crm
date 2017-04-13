package com.brp.service;

import com.brp.entity.WorkAttendancePlaceEntity;
import com.brp.util.query.WorkAttendancePlaceQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/4/12.
 */
public interface WorkAttendancePlaceService {
    void insertWorkAttendancePlace(WorkAttendancePlaceEntity workAttendancePlace);
    void updateWorkAttendancePlace(WorkAttendancePlaceEntity workAttendancePlace);
    WorkAttendancePlaceQuery getWorkAttendancePlacePage(WorkAttendancePlaceQuery workAttendancePlaceQuery);
    WorkAttendancePlaceEntity getWorkAttendancePlaceById(String id);
    void deleteWorkAttendancePlaceById(String id);
    void batchDeleteWorkAttendancePlace(List<String> idList);
    void enableOrDisableWorkAttendancePlaceById(String id);
}
