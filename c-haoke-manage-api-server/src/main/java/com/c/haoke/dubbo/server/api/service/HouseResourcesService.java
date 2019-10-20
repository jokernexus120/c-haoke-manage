package com.c.haoke.dubbo.server.api.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.c.haoke.dubbo.server.api.ApiHouseResourcesService;
import com.c.haoke.dubbo.server.api.vo.Pagination;
import com.c.haoke.dubbo.server.api.vo.TableResult;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.vo.PageInfo;
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

    public TableResult<HouseResources> queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.
                queryHouseResourcesList(currentPage, pageSize, houseResources);
        return new TableResult<>(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

}
