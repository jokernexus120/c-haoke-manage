package com.c.haoke.dubbo.server.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.c.haoke.dubbo.server.mapper")
@Configuration
public class MyBatisConfig {
}
