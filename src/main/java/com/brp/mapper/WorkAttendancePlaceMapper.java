package com.brp.mapper;

import com.brp.entity.WorkAttendancePlaceEntity;
import com.brp.util.query.WorkAttendancePlaceQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengyue on 2017/4/12.
 */
public interface WorkAttendancePlaceMapper {
    void insertWorkAttendancePlace(WorkAttendancePlaceEntity workAttendancePlace);
    List<WorkAttendancePlaceEntity> getWorkAttendancePlacePage(WorkAttendancePlaceQuery workAttendancePlaceQuery);
    WorkAttendancePlaceEntity getWorkAttendancePlaceById(String id);
    void deleteWorkAttendancePlaceById(String id);
    void batchDeleteWorkAttendancePlace(@Param("inId")String inId);
    void updateWorkAttendancePlace(WorkAttendancePlaceEntity workAttendancePlace);
    void enableOrDisableWorkAttendancePlaceById(String id);
}
