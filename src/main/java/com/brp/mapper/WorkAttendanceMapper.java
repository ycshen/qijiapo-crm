package com.brp.mapper;

import com.brp.entity.WorkAttendanceEntity;
import com.brp.util.query.WorkAttendanceQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengyue on 2017/4/11.
 */
public interface WorkAttendanceMapper {

    void insertWorkAttendance(WorkAttendanceEntity workAttendance);
    List<WorkAttendanceEntity> getWorkAttendancePage(WorkAttendanceQuery workAttendanceQuery);
    WorkAttendanceEntity getWorkAttendanceById(String id);
    void deleteWorkAttendanceById(String id);
    void batchDeleteWorkAttendance(@Param("inId")String inId);
}
