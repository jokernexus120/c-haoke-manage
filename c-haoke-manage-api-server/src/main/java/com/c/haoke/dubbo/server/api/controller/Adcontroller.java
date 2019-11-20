package com.c.haoke.dubbo.server.api.controller;


import com.c.haoke.dubbo.server.api.service.AdService;
import com.c.haoke.dubbo.server.api.vo.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ad")
@RestController
public class Adcontroller {

    @Autowired
    private AdService adService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/queryindexad")
    public WebResult  queryIndexAd(){

        return adService.queryAdList(1,1,3);
    }

    @GetMapping("/redis")
    public void  redis(){
        System.out.println("AD-------------------------------进来了");
        redisTemplate.opsForValue().set("kk", "vv" );

        String value = redisTemplate.opsForValue().get("kk");
        System.out.println(value);
        System.out.println("finish");

    }


}
