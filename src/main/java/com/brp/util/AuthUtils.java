package com.brp.util;

import com.alibaba.fastjson.JSONObject;
import com.brp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/4/7
 * @Desc qijiapo-crm-com.brp.util
 */
@Component
public class AuthUtils {
    private static CompanyService companyService;
    @Autowired(required = true)
    public void setCompanyService(CompanyService companyService){
        AuthUtils.companyService = companyService;
    }

    /**
     * 校验接口权限
     * @param jsonObject 封装的数据
     * @return 返回是否校验成功
     */
    public static Boolean auth(JSONObject jsonObject, String... args){
        String secret = jsonObject.getString("secret");
        String cId = jsonObject.getString("cId");
        try{
            if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
                String mybaseSecret = companyService.getSecretByCid(cId);
                Map<String,Object> maps = new HashMap<String, Object>();
                Set<String> keySet = jsonObject.keySet();
                Iterator<String> it = keySet.iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    if("secret".equals(key)){
                        maps.put(key, mybaseSecret);
                    }else{
                        maps.put(key, jsonObject.getString(key));
                    }
                }

                String md5 = SHA1Utils.SHA1(maps);
                if(md5.equals(secret)){
                   return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
