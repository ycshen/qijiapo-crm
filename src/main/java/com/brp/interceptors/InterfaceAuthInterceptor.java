package com.brp.interceptors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/04/07.
 */
public class InterfaceAuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(InterfaceAuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        super.preHandle(request,response,o);
      /*  Class clazz = o.getClass();

        JSONObject jsonObject = (JSONObject) o;
        Boolean auth = AuthUtils.auth(jsonObject);
        if(!auth){
            return false;
        }*/
        return true;

    }


}
