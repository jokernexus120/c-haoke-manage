package com.c.haoke.dubbo.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.c.haoke.dubbo.server.mapper")
@Configuration
public class MyBatisConfig {

    /**
     *
     * 分页插件    
     */

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
