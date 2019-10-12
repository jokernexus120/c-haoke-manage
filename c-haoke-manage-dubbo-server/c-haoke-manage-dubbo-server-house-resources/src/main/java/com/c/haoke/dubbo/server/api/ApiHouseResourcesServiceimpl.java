package com.c.haoke.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.service.HouseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;


@Service(version = "1.0.0")
public class ApiHouseResourcesServiceimpl implements ApiHouseResourcesService{

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 新增房源
     *
     * @param houseResources
     *
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */

    @Override
    public int saveHouseResources(HouseResources houseResources) {

        return this.houseResourcesService.saveHouseResources(houseResources);

    }



}
