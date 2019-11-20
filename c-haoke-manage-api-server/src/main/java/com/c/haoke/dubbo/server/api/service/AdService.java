package com.c.haoke.dubbo.server.api.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.c.haoke.dubbo.server.api.ApiAdService;
import com.c.haoke.dubbo.server.api.vo.WebResult;
import com.c.haoke.dubbo.server.pojo.Ad;
import com.c.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public WebResult queryAdList(Integer type, Integer page, Integer pageSize){

        PageInfo<Ad> pageInfo = this.apiAdService.queryAdList(type, page, pageSize);

        List<Map<String,Object>> data1 = new ArrayList<>();

        for (Ad ad:pageInfo.getRecords() ) {

            Map<String,Object> map = new HashMap<>();
            map.put("original", ad.getUrl());
            data1.add(map);

        }


        WebResult result = WebResult.ok(data1);
        return result;
    };

}
