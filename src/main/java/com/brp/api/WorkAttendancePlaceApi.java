package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.WorkAttendancePlaceEntity;
import com.brp.service.CompanyService;
import com.brp.service.WorkAttendancePlaceService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.WorkAttendancePlaceQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by fengyue on 2017/4/13.
 */
@Controller
@RequestMapping("/api-crm/workAttendancePlace")
public class WorkAttendancePlaceApi{
    @Autowired
    private WorkAttendancePlaceService workAttendancePlaceService;
    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "/insertWorkAttendancePlace", method = RequestMethod.POST)
    @ResponseBody
    public String insertWorkAttendancePlace(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String workAttendancePlace = jsonObject.getString("workAttendancePlace");
            if(StringUtils.isNotBlank(workAttendancePlace)){
                WorkAttendancePlaceEntity workAttendancePlaceObj = JSONObject.parseObject(workAttendancePlace, WorkAttendancePlaceEntity.class);
                workAttendancePlaceObj.setIsDelete(0);
                workAttendancePlaceService.insertWorkAttendancePlace(workAttendancePlaceObj);
                jsonData.setData(workAttendancePlaceObj.getId().toString());
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }

        String result = JsonUtils.json2Str(jsonData);

        return result;
    }

    @RequestMapping(value = "/getWorkAttendancePlacePage", method = RequestMethod.POST)
    @ResponseBody
    public String getWorkAttendancePlacePage(@RequestBody JSONObject jsonObject){
        JsonData<List<WorkAttendancePlaceEntity>> jsonData = new JsonData<List<WorkAttendancePlaceEntity>>();
        try{
            String query = jsonObject.getString("query");
            if(StringUtils.isNotBlank(query)){
                WorkAttendancePlaceQuery workAttendancePlaceQuery = JSONObject.parseObject(query, WorkAttendancePlaceQuery.class);
                String roleTypeStr = workAttendancePlaceQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    workAttendancePlaceQuery.setRoleType(roleTypeStr);
                }

                Integer page =  workAttendancePlaceQuery.getPage();
                if(page == null){
                    workAttendancePlaceQuery.setPage(1);
                }

                Integer size =  workAttendancePlaceQuery.getSize();
                if(size == null){
                    workAttendancePlaceQuery.setSize(10);
                }

                workAttendancePlaceQuery = workAttendancePlaceService.getWorkAttendancePlacePage(workAttendancePlaceQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(workAttendancePlaceQuery.getItems());
                jsonData.setCount(workAttendancePlaceQuery.getCount());
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }

        String result = JsonUtils.json2Str(jsonData);

        return result;
    }

    @RequestMapping(value = "/getWorkAttendancePlaceById", method = RequestMethod.POST)
    @ResponseBody
    public String getWorkAttendancePlaceById(@RequestBody JSONObject jsonObject){
        JsonData<WorkAttendancePlaceEntity> jsonData = new JsonData<WorkAttendancePlaceEntity>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                WorkAttendancePlaceEntity workAttendancePlace = workAttendancePlaceService.getWorkAttendancePlaceById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(workAttendancePlace);
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }

        String result = JsonUtils.json2Str(jsonData);

        return result;
    }

    @RequestMapping(value = "/deleteWorkAttendancePlaceById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteWorkAttendancePlaceById(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                workAttendancePlaceService.deleteWorkAttendancePlaceById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }

        String result = JsonUtils.json2Str(jsonData);

        return result;
    }


    @RequestMapping(value = "/batchDeleteWorkAttendancePlace", method = RequestMethod.POST)
    @ResponseBody
    public String batchDeleteWorkAttendancePlace(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String idList = jsonObject.getString("idList");
            if(StringUtils.isNotBlank(idList)){
                List<String> list = JSONObject.parseArray(idList, String.class);
                workAttendancePlaceService.batchDeleteWorkAttendancePlace(list);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }

        String result = JsonUtils.json2Str(jsonData);

        return result;
    }

    @RequestMapping(value = "/updateWorkAttendancePlace", method = RequestMethod.POST)
    @ResponseBody
    public String updateWorkAttendancePlace(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String workAttendancePlace = jsonObject.getString("workAttendancePlace");
            if(StringUtils.isNotBlank(workAttendancePlace)){
                WorkAttendancePlaceEntity workAttendancePlaceObj = JSONObject.parseObject(workAttendancePlace, WorkAttendancePlaceEntity.class);
                workAttendancePlaceObj.setIsDelete(0);
                workAttendancePlaceObj.setUpdateTime(new Date());
                workAttendancePlaceService.updateWorkAttendancePlace(workAttendancePlaceObj);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }

        String result = JsonUtils.json2Str(jsonData);

        return result;
    }
}
