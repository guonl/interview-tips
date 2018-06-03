package com.guonl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guonl
 * Date 2018/5/2 下午12:47
 * Description:
 */
@RestController
@RequestMapping("/redis")
public class TestRedisController {

    @RequestMapping(value = "/lock",method = RequestMethod.GET)
    public String test01(){
        System.out.println("*******");
        return "访问成功...";
    }
}
