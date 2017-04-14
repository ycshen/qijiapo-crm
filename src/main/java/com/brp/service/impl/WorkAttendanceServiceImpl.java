package com.brp.service.impl;

import com.brp.entity.WorkAttendanceEntity;
import com.brp.service.WorkAttendanceService;
import com.brp.util.query.WorkAttendanceQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/4/12.
 */
@Service
public class WorkAttendanceServiceImpl implements WorkAttendanceService {
    @Override
    public void insertWorkAttendance(WorkAttendanceEntity workAttendance) {

    }

    @Override
    public WorkAttendanceQuery getWorkAttendancePage(WorkAttendanceQuery workAttendanceQuery) {
        return null;
    }

    @Override
    public WorkAttendanceEntity getWorkAttendanceById(String id) {
        return null;
    }

    @Override
    public void deleteWorkAttendanceById(String id) {

    }

    @Override
    public void batchDeleteWorkAttendance(List<String> idList) {

    }
}
