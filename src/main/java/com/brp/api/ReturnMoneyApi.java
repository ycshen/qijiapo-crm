package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.entity.ReturnMoneyEntity;
import com.brp.service.CompanyService;
import com.brp.service.ReturnMoneyDetailService;
import com.brp.service.ReturnMoneyService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by fengyue on 2017/4/5.
 */
@Controller
@RequestMapping("/api-crm/returnMoney")
public class ReturnMoneyApi {

    @Autowired
    private ReturnMoneyService returnMoneyService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ReturnMoneyDetailService returnMoneyDetailService;
    @RequestMapping(value = "/insertReturnMoney", method = RequestMethod.POST)
    @ResponseBody
    public String insertReturnMoney(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String returnMoney = jsonObject.getString("returnMoney");
            if(StringUtils.isNotBlank(returnMoney)){
                ReturnMoneyEntity returnMoneyObj = JSONObject.parseObject(returnMoney, ReturnMoneyEntity.class);
                returnMoneyObj.setIsDelete(0);
                String returnMoneyId = UUID.randomUUID().toString().replaceAll("-", "");
                returnMoneyObj.setId(returnMoneyId);
                returnMoneyService.insertReturnMoney(returnMoneyObj);
                ReturnMoneyDetailEntity returnMoneyDetail = returnMoneyObj.getReturnMoneyDetail();
                if(returnMoneyDetail != null){
                    returnMoneyDetail.setReturnMoneyId(returnMoneyId);
                    returnMoneyDetailService.insertReturnMoneyDetail(returnMoneyDetail);
                }

                jsonData.setData(returnMoneyObj.getId().toString());
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
    @RequestMapping(value = "/getReturnMoneyById", method = RequestMethod.POST)
    @ResponseBody
    public String getReturnMoneyById(JSONObject jsonObject){
        JsonData<ReturnMoneyEntity> jsonData = new JsonData<>();
        try {
            String id = jsonObject.getString("id");
            String secret = jsonObject.getString("srcret");
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

                ReturnMoneyEntity returnMoneyEntity = returnMoneyService.getReturnMoneyById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(returnMoneyEntity);
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

    @RequestMapping(value = "/getReturnMoneyByContractId", method = RequestMethod.POST)
    @ResponseBody
    public String getSopBySaleOppoId(@RequestBody JSONObject jsonObject){
        JsonData<List<ReturnMoneyEntity>> jsonData = new JsonData<List<ReturnMoneyEntity>>();
        try{
            String contractId = jsonObject.getString("contractId");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("contractId", contractId);
                maps.put("secret", mybaseSecret);
                maps.put("cId", cId);
                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                    if(StringUtils.isNotBlank(contractId)){
                        List<ReturnMoneyEntity> list = returnMoneyService.getReturnMoneyByContractId(contractId);
                        jsonData.setData(list);
                        jsonData.setCode(ApiCode.OK);
                        jsonData.setMessage("操作成功");
                    }else{
                        jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                        jsonData.setMessage("参数异常");
                    }
                }else{
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                    return JsonUtils.json2Str(jsonData);
                }
            }else{
                jsonData.setCode(ApiCode.ARGS_EXCEPTION);
                jsonData.setMessage("参数异常");
                return JsonUtils.json2Str(jsonData);
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
