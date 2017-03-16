package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.AttnEntity;
import com.brp.service.AttnService;
import com.brp.service.CompanyService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.AttnQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengyue on 2017/3/9.
 */
@Controller
@RequestMapping("/api-crm/attn")
public class AttnApi {
    @Autowired
    private AttnService attnService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/insertAttn", method = RequestMethod.POST)
    @ResponseBody
    public String insertAttn(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String attn = jsonObject.getString("attn");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("attn", attn);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    auth = true;
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }

            if(auth && StringUtils.isNotBlank(attn)){
                AttnEntity attnObj = JSONObject.parseObject(attn, AttnEntity.class);
                attnObj.setIsDelete(0);
                attnService.insertAttn(attnObj);
                jsonData.setData(attnObj.getId().toString());
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

    @RequestMapping(value = "/getAttnPage", method = RequestMethod.POST)
    @ResponseBody
    public String getAttnPage(@RequestBody JSONObject jsonObject){
        JsonData<List<AttnEntity>> jsonData = new JsonData<List<AttnEntity>>();
        try{
            String query = jsonObject.getString("query");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("query", query);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    auth = true;
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }

            if(auth){
                AttnQuery AttnQuery = JSONObject.parseObject(query, AttnQuery.class);
                String roleTypeStr = AttnQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    AttnQuery.setRoleType(roleTypeStr);
                }

                Integer page =  AttnQuery.getPage();
                if(page == null){
                    AttnQuery.setPage(1);
                }

                Integer size =  AttnQuery.getSize();
                if(size == null){
                    AttnQuery.setSize(10);
                }

                AttnQuery = attnService.getAttnPage(AttnQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(AttnQuery.getItems());
                jsonData.setCount(AttnQuery.getCount());
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

    @RequestMapping(value = "/getAttnById", method = RequestMethod.POST)
    @ResponseBody
    public String getAttnById(@RequestBody JSONObject jsonObject){
        JsonData<AttnEntity> jsonData = new JsonData<AttnEntity>();
        try{
            String id = jsonObject.getString("id");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("id", id);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    auth = true;
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }

            if(auth && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                AttnEntity attn = attnService.getAttnById(id);
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

    @RequestMapping(value = "/deleteAttnById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAttnById(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String id = jsonObject.getString("id");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("id", id);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    auth = true;
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }

            if(auth && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                attnService.deleteAttnById(id);
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


    @RequestMapping(value = "/batchDeleteAttn", method = RequestMethod.POST)
    @ResponseBody
    public String batchDeleteAttn(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String idList = jsonObject.getString("idList");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("idList", idList);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    auth = true;
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }

            if(auth && StringUtils.isNotBlank(idList)){
                List<String> list = JSONObject.parseArray(idList, String.class);
                attnService.batchDeleteAttn(list);
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

    @RequestMapping(value = "/updateAttn", method = RequestMethod.POST)
    @ResponseBody
    public String updateAttn(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String attn = jsonObject.getString("attn");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("attn", attn);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    auth = true;
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
            }

            if(auth && StringUtils.isNotBlank(attn)){
                AttnEntity attnObj = JSONObject.parseObject(attn, AttnEntity.class);
                attnObj.setIsDelete(0);
                attnObj.setUpdateTime(new Date());
                attnService.updateAttn(attnObj);
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
