package com.sr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/27.
 */
@RestController
public class Controller {

    @RequestMapping("/test")
    public Object test(){
        Map map = new HashMap();
        map.put("ip","10.1.1.1");
        map.put("port","8080");
        return map;
    }
}
