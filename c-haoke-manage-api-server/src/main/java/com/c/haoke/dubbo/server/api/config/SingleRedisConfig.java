package com.c.haoke.dubbo.server.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class SingleRedisConfig {

    @Autowired
    private RedisStandalonProperties redisStandalonProperties;

    @Bean
    public RedisConnectionFactory connectionFactory() {


        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisStandalonProperties.getHost(), redisStandalonProperties.getPort());

        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisStandaloneConfiguration) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisStandaloneConfiguration);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();

        System.out.println("创建SingleRedisTemplate");
        return redisTemplate;


    }
}
