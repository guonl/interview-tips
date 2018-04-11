package com.guonl.session;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guonl
 * Date 2018/4/10 下午9:28
 * Description: 测试springsession共享
 */
@Api
@RestController
public class SessionTestController {

    /**
     * 模拟登陆，在session中存储一个值
     * http://127.0.0.1:8080/login
     * @param request
     * @return
     */
    @ApiOperation("登录")
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public Map<String,Object> login(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        // 设置session中的值
        httpSession.setAttribute("username", "guonl" + System.currentTimeMillis());

        Map<String,Object> rtnMap = new HashMap<>();
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            rtnMap.put(name, httpSession.getAttribute(name));
        }
        rtnMap.put("sessionId", httpSession.getId());
        return rtnMap;
    }

    /**
     * 从session中获取值
     * http://127.0.0.1:8080/get-session
     * @param request
     * @return
     */
    @ApiOperation("获取session")
    @RequestMapping(value = "get-session",method = RequestMethod.GET)
    public Object getSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Map<String,Object> rtnMap = new HashMap<>();
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            rtnMap.put(name, httpSession.getAttribute(name));
        }
        int count;
        try {
            count = Integer.parseInt(String.valueOf(httpSession.getAttribute("count")));
            count++;
        }catch (NumberFormatException e){
            count = 1;
        }
        httpSession.setAttribute("count",count+"");

        rtnMap.put("sessionId", httpSession.getId());
        return rtnMap;
    }

    @ApiOperation("session失效")
    @RequestMapping(value = "invalidate",method = RequestMethod.GET)
    public int invalidate(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return 1;
    }



}
