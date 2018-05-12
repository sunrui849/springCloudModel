package com.sr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/27.
 */
@RestController
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/callGetMovieName")
    public Object test(int param){
        System.out.println(param);
        Map params = new HashMap<>();
        params.put("param",param);
        MultiValueMap m;
        Map map = new HashMap();
        map.put("ctr","ribbon1");
        map.put("movieName",restTemplate.getForObject("http://service-1/getMovesName?param=1",String.class,params));
        return map;
    }


    @RequestMapping("/callGetIP")
    public Object test2(){
        Map map = new HashMap();
        map.put("ctr","ribbon1");
        map.put("IP",restTemplate.getForObject("http://service-1/ip",Map.class));
        return map;
    }
}
