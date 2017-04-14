package com.brp.service.impl;

import com.brp.entity.AttnEntity;
import com.brp.entity.WorkAttendanceEntity;
import com.brp.mapper.WorkAttendanceMapper;
import com.brp.service.WorkAttendanceService;
import com.brp.util.query.WorkAttendanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/4/12.
 */
@Service
public class WorkAttendanceServiceImpl implements WorkAttendanceService {

    @Autowired
    private WorkAttendanceMapper workAttendanceMapper;

    @Override
    public void insertWorkAttendance(WorkAttendanceEntity workAttendance) {
        workAttendanceMapper.insertWorkAttendance(workAttendance);
    }

    @Override
    public WorkAttendanceQuery getWorkAttendancePage(WorkAttendanceQuery workAttendanceQuery) {
        List<WorkAttendanceEntity> workAttendanceEntities = workAttendanceMapper.getWorkAttendancePage(workAttendanceQuery);
        if (workAttendanceEntities != null && workAttendanceEntities.size() > 0){
            workAttendanceQuery.setItems(workAttendanceEntities);
        }
        return workAttendanceQuery;
    }

    @Override
    public WorkAttendanceEntity getWorkAttendanceById(String id) {
        return workAttendanceMapper.getWorkAttendanceById(id);
    }

    @Override
    public void deleteWorkAttendanceById(String id) {

    }

    @Override
    public void batchDeleteWorkAttendance(List<String> idList) {

    }
}
