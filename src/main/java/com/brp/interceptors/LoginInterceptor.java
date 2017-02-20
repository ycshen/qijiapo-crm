package com.brp.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.brp.entity.UserEntity;

/**
 * Created by Administrator on 2016/3/23.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        super.preHandle(request,response,o);
        HttpSession seesion = request.getSession();
        //response.sendRedirect("login");
        UserEntity loginUser = (UserEntity) seesion.getAttribute("loginUser");
        if(loginUser == null){
        	response.sendRedirect("/login");
			return false;
        	
        }
        
        return true;

    }


}
