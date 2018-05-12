package com.sr.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/5/5.
 */
@Component//这个注解一定要加
public class Service1HyStrix implements FallbackFactory<Service1>{

    @Override
    public Service1 create(Throwable throwable) {
        return new Service1() {
            @Override
            public String getMvName(@RequestParam("param") String param) {
                System.out.println("callGetMovieNameHystrix");

                return "统一实现了服务降级，参数为"+param;
            }

            @Override
            public Object getIP() {
                return "统一实现了服务降级，无参数";
            }
        };
    }
}
