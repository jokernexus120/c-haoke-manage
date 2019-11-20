package com.c.haoke.dubbo.server.api.intercepter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class RedisCacheInterceptor implements HandlerInterceptor {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("被RedisCacheInterceptor拦截了");
        if (!StringUtils.equalsIgnoreCase(request.getMethod(),"get"))
        {
            return true;
        }
        String redisKey =  getRedisKey(request);
        System.out.println("redisKey:   "+redisKey);
        String redisData = redisTemplate.opsForValue().get(redisKey);
        if (redisData==null||redisData.isEmpty())
        {
            return true;
        }
        System.out.println("从redis中查出数据: "+redisData);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        // 支持跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(redisData);


        return false;
    }

    public static String getRedisKey(HttpServletRequest request) throws Exception{

        String paramStr = request.getRequestURI();
        Map<String,String[]> paramMapStr = request.getParameterMap();
        if (paramMapStr.isEmpty())
        {
            paramStr += IOUtils.toString(request.getInputStream(),"UTF-8");

        }else {
            paramStr += mapper.writeValueAsString(paramMapStr);
        }

        String redisKey = "WEB_DATA_" + paramStr;

        System.out.println("生成redisKey "+redisKey);
        return redisKey;
    }

}
