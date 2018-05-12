package com.sr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/27.
 */
@RestController
public class Controller {

    @RequestMapping("/ip")
    public Object test(){
        Map map = new HashMap();
        map.put("ip","10.1.1.1");
        map.put("port","8080");
        map.put("service","为事故service2");
        return map;
    }


    @RequestMapping("/getMovesName")
    public String getMovesName(String param){
        System.out.println(param);
        if("1".equals(param)){
            return "好莱坞大片(来自服务2)";
        }else{
            return "动画片(来自服务2)";
        }
    }



}
