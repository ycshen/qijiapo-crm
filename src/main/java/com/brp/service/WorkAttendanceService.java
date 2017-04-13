package com.brp.service;

import com.brp.entity.WorkAttendanceEntity;
import com.brp.util.query.WorkAttendanceQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/4/12.
 */
public interface WorkAttendanceService {
    void insertWorkAttendance(WorkAttendanceEntity workAttendance);
    WorkAttendanceQuery getWorkAttendancePage(WorkAttendanceQuery workAttendanceQuery);
    WorkAttendanceEntity getWorkAttendanceById(String id);
    void deleteWorkAttendanceById(String id);
    void batchDeleteWorkAttendance(List<String> idList);
}
