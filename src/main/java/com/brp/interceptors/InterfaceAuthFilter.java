package com.brp.interceptors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.brp.util.AuthUtils;
import com.brp.util.JsonUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/4/10
 * @Desc qijiapo-crm-${PACKAGE_NAME}
 */
public class InterfaceAuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest requestWrapper = null;
        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            if ("POST".equals(httpServletRequest.getMethod().toUpperCase())
                    && httpServletRequest.getContentType().equalsIgnoreCase(
                    "application/json;charset=utf-8")) {
                requestWrapper = new BodyReaderHttpServletRequestWrapper(
                        (HttpServletRequest) req);
                String jsonStr = IOUtils.toString(requestWrapper.getInputStream());
                JSONObject jsonObject = JSONArray.parseObject(jsonStr);
                Boolean auth = AuthUtils.auth(jsonObject);
                JsonData<String> jsonData = new JsonData<String>();
                if(!auth){
                    jsonData.setCode(ApiCode.AUTH_FAIL);
                    jsonData.setMessage("验证失败");
                    String returnJson = JsonUtils.json2Str(jsonData);
                    PrintWriter printWriter = null;
                    try {
                        printWriter = resp.getWriter();
                        printWriter.print(returnJson);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if(printWriter != null){
                            printWriter.close();
                        }
                    }

                    return;
                }else {
                    chain.doFilter(requestWrapper, resp);
                }
            }else {
                chain.doFilter(req, resp);
            }
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
