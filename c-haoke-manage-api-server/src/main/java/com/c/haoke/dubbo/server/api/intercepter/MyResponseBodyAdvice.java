package com.c.haoke.dubbo.server.api.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        if (methodParameter.hasMethodAnnotation(GetMapping.class))
        {
            return true;
        }

        return false;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();

     try{
         String redisKey = RedisCacheInterceptor.getRedisKey(httpServletRequest);
         String redisValue = "";
         if (object instanceof String)
         {
             redisValue = (String)object;
         }else
         {
             redisValue = mapper.writeValueAsString(object);

         }
         this.redisTemplate.opsForValue().set(redisKey,redisValue,Duration.ofHours(1));
         System.out.println("Input:");
         System.out.println("rediskey "+redisKey);
         System.out.println("redisValue "+redisValue);
         System.out.println("对数据库返回的数据进行了缓存");

     }catch (Exception e){
         System.out.println("beforeBodyWrite报错了");
     }


        return object;
    }
}
