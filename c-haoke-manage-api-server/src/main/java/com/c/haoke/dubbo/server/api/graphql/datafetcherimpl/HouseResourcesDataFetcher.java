package com.c.haoke.dubbo.server.api.graphql.datafetcherimpl;

import com.c.haoke.dubbo.server.api.graphql.MyDataFetcher;
import com.c.haoke.dubbo.server.api.service.HouseResourcesService;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesDataFetcher implements MyDataFetcher {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String fieldName() {
        return "houseResources";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Long id = environment.getArgument("id");
        HouseResources houseResources = this.houseResourcesService.selectHouseResourcesById(id);
        return houseResources;
    }
}
