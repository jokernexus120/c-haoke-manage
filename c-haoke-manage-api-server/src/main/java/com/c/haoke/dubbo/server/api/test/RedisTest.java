package com.c.haoke.dubbo.server.api.test;

import com.c.haoke.dubbo.server.api.config.ClusterConfigurationProperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSave() {


        this.redisTemplate.opsForValue().set("key_c", "value_c");


        for (int i = 10; i < 20; i++) {
            this.redisTemplate.opsForValue().set("key_" + i, "value_" + i);
            System.out.println("key_" + i+":"+"value_" + i);

        }
        for (int i = 10; i < 20; i++) {
            String value = this.redisTemplate.opsForValue().get("key_" + i);
            System.out.println("key_" + i+":"+value);

        }





    }

/*
    @Autowired
    private ClusterConfigurationProperties clusterConfigurationProperties;

    @Autowired
    private JedisClusterConfig jedisClusterConfig;

    @Test
    public void testData(){
        String str=jedisClusterConfig.getJedisCluster().get("cwx4");
        System.out.println(str);
        String str1=jedisClusterConfig.getJedisCluster().get("cwx5");
        System.out.println(str1);
    }
*/


}
