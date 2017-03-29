package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.SalesLeadsEntity;
import com.brp.service.CompanyService;
import com.brp.service.SalesLeadsService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.SalesLeadsQuery;
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
 * Created by fengyue on 2017/3/28.
 */
@Controller
@RequestMapping("/api-crm/salesLeads")
public class SalesLeadsApi {

    @Autowired
    private SalesLeadsService salesLeadsService;
    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "/insertSalesLeads", method = RequestMethod.POST)
    @ResponseBody
    public String insertSalesLeads(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String salesLeads = jsonObject.getString("salesLeads");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("salesLeads", salesLeads);
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

            if(auth && StringUtils.isNotBlank(salesLeads)){
                SalesLeadsEntity salesLeadsObj = JSONObject.parseObject(salesLeads, SalesLeadsEntity.class);
                salesLeadsObj.setIsDelete(0);
                salesLeadsService.insertSalesLeads(salesLeadsObj);
                jsonData.setData(salesLeadsObj.getId().toString());
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

    @RequestMapping(value = "/getSalesLeadsPage", method = RequestMethod.POST)
    @ResponseBody
    public String getSalesLeadsPage(@RequestBody JSONObject jsonObject){
        JsonData<List<SalesLeadsEntity>> jsonData = new JsonData<List<SalesLeadsEntity>>();
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
                SalesLeadsQuery salesLeadsQuery = JSONObject.parseObject(query, SalesLeadsQuery.class);
                String roleTypeStr = salesLeadsQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    salesLeadsQuery.setRoleType(roleTypeStr);
                }

                Integer page =  salesLeadsQuery.getPage();
                if(page == null){
                    salesLeadsQuery.setPage(1);
                }

                Integer size =  salesLeadsQuery.getSize();
                if(size == null){
                    salesLeadsQuery.setSize(10);
                }

                salesLeadsQuery = salesLeadsService.getSalesLeadsPage(salesLeadsQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(salesLeadsQuery.getItems());
                jsonData.setCount(salesLeadsQuery.getCount());
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

    @RequestMapping(value = "/getSalesLeadsById", method = RequestMethod.POST)
    @ResponseBody
    public String getSalesLeadsById(@RequestBody JSONObject jsonObject){
        JsonData<SalesLeadsEntity> jsonData = new JsonData<SalesLeadsEntity>();
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

                SalesLeadsEntity salesLeads = salesLeadsService.getSalesLeadsById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(salesLeads);
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

    @RequestMapping(value = "/deleteSalesLeadsById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteSalesLeadsById(@RequestBody JSONObject jsonObject){
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

                salesLeadsService.deleteSalesLeadsById(id);
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


    @RequestMapping(value = "/batchDeleteSalesLeads", method = RequestMethod.POST)
    @ResponseBody
    public String batchDeleteSalesLeads(@RequestBody JSONObject jsonObject){
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
                salesLeadsService.batchDeleteSalesLeads(list);
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

    @RequestMapping(value = "/updateSalesLeads", method = RequestMethod.POST)
    @ResponseBody
    public String updateSalesLeads(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String salesLeads = jsonObject.getString("salesLeads");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("salesLeads", salesLeads);
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

            if(auth && StringUtils.isNotBlank(salesLeads)){
                SalesLeadsEntity salesLeadsObj = JSONObject.parseObject(salesLeads, SalesLeadsEntity.class);
                salesLeadsObj.setIsDelete(0);
                salesLeadsObj.setUpdateTime(new Date());
                salesLeadsService.updateSalesLeads(salesLeadsObj);
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
