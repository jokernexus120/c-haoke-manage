package com.c.haoke.dubbo.server.api.config;

import com.c.haoke.dubbo.server.api.vo.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public IdWorker getIdWorker(){
        IdWorker idWorker = new IdWorker(1,0);

        return idWorker;
    }

}
