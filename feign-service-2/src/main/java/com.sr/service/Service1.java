package com.sr.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-1")
public interface Service1 {

    @RequestMapping("/getMovesName")
    public String getMvName(@RequestParam("param") String param);

    @RequestMapping("/ip")
    public Object getIP();
}
