package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.ActivityEntity;
import com.brp.service.ActivityService;
import com.brp.service.CompanyService;
import com.brp.util.JsonUtils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.ActivityQuery;
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
 * Created by fengyue on 2017/3/22.
 */
@Controller
@RequestMapping("/api-crm/activity")
public class ActivityApi {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "/insertActivity", method = RequestMethod.POST)
    @ResponseBody
    public String insertActivity(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<>();
        try {
            String activity = jsonObject.getString("activity");
            if(StringUtils.isNotBlank(activity)){
                ActivityEntity activityEntity = JSONObject.parseObject(activity, ActivityEntity.class);
                activityEntity.setIsDelete(0);
                activityService.insertActivity(activityEntity);
                jsonData.setData(activityEntity.getId().toString());
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonData.setCode(ApiCode.EXCEPTION);
            jsonData.setMessage("操作失败");
        }


        String result = JsonUtils.json2Str(jsonData);

        return result;
    }

    @RequestMapping(value = "/getActivityPage", method = RequestMethod.POST)
    @ResponseBody
    public String getActivityPage(@RequestBody JSONObject jsonObject){
        JsonData<List<ActivityEntity>> jsonData = new JsonData<List<ActivityEntity>>();
        try{
            String query = jsonObject.getString("query");
            if(StringUtils.isNotBlank(query)){
                ActivityQuery activityQuery = JSONObject.parseObject(query, ActivityQuery.class);
                String roleTypeStr = activityQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    activityQuery.setRoleType(roleTypeStr);
                }

                Integer page =  activityQuery.getPage();
                if(page == null){
                    activityQuery.setPage(1);
                }

                Integer size =  activityQuery.getSize();
                if(size == null){
                    activityQuery.setSize(10);
                }

                activityQuery = activityService.getActivityPage(activityQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(activityQuery.getItems());
                jsonData.setCount(activityQuery.getCount());
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

    @RequestMapping(value = "/getActivityById", method = RequestMethod.POST)
    @ResponseBody
    public String getActivityById(@RequestBody JSONObject jsonObject){
        JsonData<ActivityEntity> jsonData = new JsonData<ActivityEntity>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                ActivityEntity activity = activityService.getActivityById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(activity);
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

    @RequestMapping(value = "/deleteActivityById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteActivityById(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                activityService.deleteActivityById(id);
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


    @RequestMapping(value = "/batchDeleteActivity", method = RequestMethod.POST)
    @ResponseBody
    public String batchDeleteActivity(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String idList = jsonObject.getString("idList");
            if(StringUtils.isNotBlank(idList)){
                List<String> list = JSONObject.parseArray(idList, String.class);
                activityService.batchDeleteActivity(list);
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

    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    @ResponseBody
    public String updateActivity(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String activity = jsonObject.getString("activity");
            if(StringUtils.isNotBlank(activity)){
                ActivityEntity activityObj = JSONObject.parseObject(activity, ActivityEntity.class);
                activityObj.setIsDelete(0);
                activityObj.setUpdateTime(new Date());
                activityService.updateActivity(activityObj);
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
