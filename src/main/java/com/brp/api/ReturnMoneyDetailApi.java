package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.ReturnMoneyDetailEntity;
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
import com.brp.util.query.ReturnMoneyDetailQuery;
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
 * Created by fengyue on 2017/4/7.
 */
@Controller
@RequestMapping("/api-crm/rda")
public class ReturnMoneyDetailApi {

    @Autowired
    private ReturnMoneyDetailService returnMoneyDetailService;
    @Autowired
    private ReturnMoneyService returnMoneyService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/insertReturnMoneyDetail", method = RequestMethod.POST)
    @ResponseBody
    public String insertReturnMoney(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String rmd = jsonObject.getString("returnMoneyDetail");
            String secret = jsonObject.getString("secret");
            String cId = jsonObject.getString("cId");

            boolean auth = false;
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                maps.put("returnMoneyDetail", rmd);
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

            if(auth && StringUtils.isNotBlank(rmd)){
                ReturnMoneyDetailEntity rmdObj = JSONObject.parseObject(rmd, ReturnMoneyDetailEntity.class);
                rmdObj.setIsDelete(0);
                returnMoneyDetailService.insertReturnMoneyDetail(rmdObj);
                if (rmdObj.getReturnMoneyType() == 1){//实际回款，更新回款字段
                    ReturnMoneyEntity returnMoneyEntity = returnMoneyService.getReturnMoneyById(rmdObj.getReturnMoneyId());
                    double actualReturnMoney = Double.parseDouble(returnMoneyEntity.getActualReturnMoney()) + Double.parseDouble(rmdObj.getMoney());
                    returnMoneyEntity.setActualReturnMoney(actualReturnMoney + "");
                    returnMoneyService.updateReturnMoney(returnMoneyEntity);
                }
                jsonData.setData(rmdObj.getId().toString());
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

    @RequestMapping(value = "getReturnMoneyDetailById")
    @ResponseBody
    public String getReturnMoneyDetailById(@RequestBody JSONObject jsonObject){
        JsonData<ReturnMoneyDetailEntity> jsonData = new JsonData<>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                ReturnMoneyDetailEntity returnMoneyDetailEntity = returnMoneyDetailService.getReturnMoneyDetailById(id);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(returnMoneyDetailEntity);
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

    @RequestMapping(value = "getReturnMoneyDetailPage")
    @ResponseBody
    public String getRMDByReturnMoneyId(@RequestBody JSONObject jsonObject){
        JsonData<List<ReturnMoneyDetailEntity>> jsonData = new JsonData<>();
        try{
            String query = jsonObject.getString("query");
            if(StringUtils.isNotBlank(query)){
                ReturnMoneyDetailQuery returnMoneyDetailQuery = JSONObject.parseObject(query, ReturnMoneyDetailQuery.class);
                String roleTypeStr = returnMoneyDetailQuery.getRoleType();
                if(StringUtils.isBlank(roleTypeStr)){
                    roleTypeStr = "3";
                    returnMoneyDetailQuery.setRoleType(roleTypeStr);
                }

                Integer page =  returnMoneyDetailQuery.getPage();
                if(page == null){
                    returnMoneyDetailQuery.setPage(1);
                }

                Integer size =  returnMoneyDetailQuery.getSize();
                if(size == null){
                    returnMoneyDetailQuery.setSize(10);
                }

                returnMoneyDetailQuery = returnMoneyDetailService.getRMDByReturnMoneyId(returnMoneyDetailQuery);
                jsonData.setCode(ApiCode.OK);
                jsonData.setMessage("操作成功");
                jsonData.setData(returnMoneyDetailQuery.getItems());
                jsonData.setCount(returnMoneyDetailQuery.getCount());
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

    @RequestMapping(value = "/deleteReturnMoneyDetailById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteReturnMoneyDetailById(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String id = jsonObject.getString("id");
            if(StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){

                returnMoneyDetailService.deleteReturnMoneyDetailById(id);
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
    @RequestMapping(value = "/updateReturnMoneyDetail", method = RequestMethod.POST)
    @ResponseBody
    public String updateReturnMoneyDetail(@RequestBody JSONObject jsonObject){
        JsonData<String> jsonData = new JsonData<String>();
        try{
            String returnMoneyDetail = jsonObject.getString("returnMoneyDetail");
            if(StringUtils.isNotBlank(returnMoneyDetail)){
                ReturnMoneyDetailEntity returnMoneyDetailObj = JSONObject.parseObject(returnMoneyDetail, ReturnMoneyDetailEntity.class);
                returnMoneyDetailObj.setIsDelete(0);
                returnMoneyDetailObj.setUpdateTime(new Date());
                returnMoneyDetailService.updateReturnMoneyDetail(returnMoneyDetailObj);
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
