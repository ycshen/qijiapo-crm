package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.entity.ReturnMoneyEntity;
import com.brp.service.CompanyService;
import com.brp.service.ReturnMoneyDetailService;
import com.brp.service.ReturnMoneyService;
import com.brp.util.JsonUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.ReturnMoneyQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

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
    public String getReturnMoneyById(@RequestBody JSONObject jsonObject){
        JsonData<ReturnMoneyEntity> jsonData = new JsonData<>();
        try {
            String id = jsonObject.getString("id");
            if( StringUtils.isNotBlank(id)){
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

    @RequestMapping(value = "/getReturnMoneyPageByContractId", method = RequestMethod.POST)
    @ResponseBody
    public String getReturnMoneyPageByContractId(@RequestBody JSONObject jsonObject){
        JsonData<List<ReturnMoneyEntity>> jsonData = new JsonData<List<ReturnMoneyEntity>>();
        try{
            String query = jsonObject.getString("query");
            if(StringUtils.isNotBlank(query)){
                ReturnMoneyQuery returnMoneyQuery = JSONObject.parseObject(query, ReturnMoneyQuery.class);
                String roleTypeStr = returnMoneyQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    returnMoneyQuery.setRoleType(roleTypeStr);
                }

                Integer page =  returnMoneyQuery.getPage();
                if(page == null){
                    returnMoneyQuery.setPage(1);
                }

                Integer size =  returnMoneyQuery.getSize();
                if(size == null){
                    returnMoneyQuery.setSize(10);
                }

                returnMoneyQuery = returnMoneyService.getReturnMoneyByContractId(returnMoneyQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(returnMoneyQuery.getItems());
                jsonData.setCount(returnMoneyQuery.getCount());
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
