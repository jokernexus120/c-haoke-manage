package com.c.haoke.dubbo.server.api.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.c.haoke.dubbo.server.api.ApiHouseResourcesService;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {




    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources) {
        int result =
                this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

}
