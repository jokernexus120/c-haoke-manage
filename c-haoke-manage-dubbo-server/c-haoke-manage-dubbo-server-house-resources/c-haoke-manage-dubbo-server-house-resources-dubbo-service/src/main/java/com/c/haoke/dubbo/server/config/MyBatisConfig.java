package com.c.haoke.dubbo.server.config;


import com.c.haoke.dubbo.server.pojo.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.c.haoke.dubbo.server.mapper")
@Configuration
public class MyBatisConfig {

    @Bean
    public IdWorker getIdWorker(){
        IdWorker idWorker = new IdWorker(1,0);

        return idWorker;
    }

}
