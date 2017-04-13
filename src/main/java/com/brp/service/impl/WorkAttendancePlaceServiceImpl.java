package com.brp.service.impl;

import com.brp.entity.WorkAttendancePlaceEntity;
import com.brp.mapper.WorkAttendancePlaceMapper;
import com.brp.service.WorkAttendancePlaceService;
import com.brp.util.StringUtils;
import com.brp.util.query.WorkAttendancePlaceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/4/12.
 */
@Service
public class WorkAttendancePlaceServiceImpl implements WorkAttendancePlaceService {

    @Autowired
    WorkAttendancePlaceMapper attendancePlaceMapper;

    @Override
    public void insertWorkAttendancePlace(WorkAttendancePlaceEntity workAttendancePlace) {
        attendancePlaceMapper.insertWorkAttendancePlace(workAttendancePlace);
    }

    @Override
    public void updateWorkAttendancePlace(WorkAttendancePlaceEntity workAttendancePlace) {
        attendancePlaceMapper.updateWorkAttendancePlace(workAttendancePlace);
    }

    @Override
    public WorkAttendancePlaceQuery getWorkAttendancePlacePage(WorkAttendancePlaceQuery workAttendancePlaceQuery) {
        List<WorkAttendancePlaceEntity> list = attendancePlaceMapper.getWorkAttendancePlacePage(workAttendancePlaceQuery);
        if(list != null && list.size() > 0){
            workAttendancePlaceQuery.setItems(list);
        }
        return workAttendancePlaceQuery;
    }

    @Override
    public WorkAttendancePlaceEntity getWorkAttendancePlaceById(String id) {
        return attendancePlaceMapper.getWorkAttendancePlaceById(id);
    }

    @Override
    public void deleteWorkAttendancePlaceById(String id) {
        attendancePlaceMapper.deleteWorkAttendancePlaceById(id);
    }

    @Override
    public void batchDeleteWorkAttendancePlace(List<String> idList) {
        if(idList != null && idList.size() > 0){
            String inId = "";
            for (String id : idList) {
                inId += id + ",";
            }

            if(StringUtils.isNotBlank(inId)){
                inId = inId.substring(0, inId.length() - 1);
                attendancePlaceMapper.batchDeleteWorkAttendancePlace(inId);
            }
        }
    }

    @Override
    public void enableOrDisableWorkAttendancePlaceById(String id) {
        attendancePlaceMapper.enableOrDisableWorkAttendancePlaceById(id);
    }
}
