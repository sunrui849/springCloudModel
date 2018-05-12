package com.sr.controller;

import com.sr.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/27.
 */
@RestController
public class Controller {

    @Autowired
    Service1 service1;

    @RequestMapping("/callGetMovieName")
    public Object test(String param){
        System.out.println("callGetMovieName");
        Map map = new HashMap();
        map.put("ctr","feign1");
        map.put("movieName",service1.getMvName(param));
        return map;
    }


    @RequestMapping("/callGetIP")
    public Object test2(){
        Map map = new HashMap();
        map.put("ctr","feign1");
        map.put("IP",service1.getIP());
        return map;
    }
}
