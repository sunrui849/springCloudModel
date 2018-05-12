package com.sr.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
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
        map.put("service","我是service1");
        return map;
    }

    @HystrixCommand(fallbackMethod = "getMovesNameHystrix")
    @RequestMapping("/getMovesName")
    public String getMovesName(String param){
        System.out.println(param);
        if(param.equals("hystrix")) {
            throw new RuntimeException("抛出异常并将进入熔断");
        }
        if("1".equals(param)){
            return "好莱坞大片(来自服务1)";
        }else{
            return "动画片(来自服务1)";
        }
    }

    @Value("${ip}")
    String ip;

    @Value("${port}")
    String port;

    @RequestMapping("/getConfig")
    public String getConfig(){
        return ip+"："+port+"(从配置中心获取)";
    }



    public String getMovesNameHystrix(String param){

        return "进入了熔断处理中，参数为"+param;
    }
}
