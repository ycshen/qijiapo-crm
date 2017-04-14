package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.WorkAttendanceEntity;
import com.brp.entity.WorkAttendanceEntity;
import com.brp.service.CompanyService;
import com.brp.service.WorkAttendanceService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.WorkAttendanceQuery;
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
@RequestMapping("/api-crm/workAttendance")
public class WorkAttendanceApi {

    @Autowired
    private WorkAttendanceService workAttendanceService;

    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "/insertWorkAttendance", method = RequestMethod.POST)
    @ResponseBody
    public String insertAttn(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String attn = jsonObject.getString("attn");
            if(StringUtils.isNotBlank(attn)){
                WorkAttendanceEntity workAttendanceEntity = JSONObject.parseObject(attn, WorkAttendanceEntity.class);
                workAttendanceEntity.setIsDelete(0);
                workAttendanceService.insertWorkAttendance(workAttendanceEntity);
                jsonData.setData(workAttendanceEntity.getId().toString());
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

    @RequestMapping(value = "/getWorkAttendancePage", method = RequestMethod.POST)
    @ResponseBody
    public String getAttnPage(@RequestBody JSONObject jsonObject){
        JsonData<List<WorkAttendanceEntity>> jsonData = new JsonData<List<WorkAttendanceEntity>>();
        try{
            String query = jsonObject.getString("query");
            if(StringUtils.isNotBlank(query)){
                WorkAttendanceQuery WorkAttendanceQuery = JSONObject.parseObject(query, WorkAttendanceQuery.class);
                String roleTypeStr = WorkAttendanceQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    WorkAttendanceQuery.setRoleType(roleTypeStr);
                }

                Integer page =  WorkAttendanceQuery.getPage();
                if(page == null){
                    WorkAttendanceQuery.setPage(1);
                }

                Integer size =  WorkAttendanceQuery.getSize();
                if(size == null){
                    WorkAttendanceQuery.setSize(10);
                }

                WorkAttendanceQuery = workAttendanceService.getWorkAttendancePage(WorkAttendanceQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(WorkAttendanceQuery.getItems());
                jsonData.setCount(WorkAttendanceQuery.getCount());
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

    @RequestMapping(value = "/getWorkAttendanceById", method = RequestMethod.POST)
    @ResponseBody
    public String getAttnById(@RequestBody JSONObject jsonObject){
        JsonData<WorkAttendanceEntity> jsonData = new JsonData<WorkAttendanceEntity>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                WorkAttendanceEntity attn = workAttendanceService.getWorkAttendanceById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(attn);
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

    @RequestMapping(value = "/deleteWorkAttendanceById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAttnById(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                workAttendanceService.deleteWorkAttendanceById(id);
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


    @RequestMapping(value = "/batchDeleteWorkAttendance", method = RequestMethod.POST)
    @ResponseBody
    public String batchDeleteAttn(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String idList = jsonObject.getString("idList");
            if(StringUtils.isNotBlank(idList)){
                List<String> list = JSONObject.parseArray(idList, String.class);
                workAttendanceService.batchDeleteWorkAttendance(list);
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
