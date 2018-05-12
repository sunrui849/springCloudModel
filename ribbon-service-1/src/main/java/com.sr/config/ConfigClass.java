package com.sr.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/5/5.
 */
@Configuration
public class ConfigClass {

    @Bean
    public IRule myRule(){
        return new RandomRule();//采用随机轮训方式
    }
}
