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

import java.util.HashMap;
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
}
