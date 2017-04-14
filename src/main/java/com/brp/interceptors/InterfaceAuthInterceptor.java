package com.brp.interceptors;


import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.brp.util.AuthUtils;

import redis.clients.util.IOUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/04/07.
 */
public class InterfaceAuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(InterfaceAuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        
       /* String requestBody= org.apache.commons.io.IOUtils.toString(request.getInputStream()); 
        JSONObject jsonObject = JSONArray.parseObject(requestBody);
        Boolean auth = AuthUtils.auth(jsonObject);
        if(!auth){
            return false;
        }*/
        
       /* HttpServletRequest requestWrapper = null;  
        if (request instanceof HttpServletRequest) {  
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;  
            if ("POST".equals(httpServletRequest.getMethod().toUpperCase())  
                    && httpServletRequest.getContentType().equalsIgnoreCase(  
                            "application/json;charset=utf-8")) {  
                requestWrapper = new BodyReaderHttpServletRequestWrapper(  
                        (HttpServletRequest) request);  
            }  
        }  
  
        if (requestWrapper == null) {  
        	super.preHandle(request,response,handler);
        } else {  
        	super.preHandle(requestWrapper,response,handler);  
        }  */
        
        
        return true;

    }


}
