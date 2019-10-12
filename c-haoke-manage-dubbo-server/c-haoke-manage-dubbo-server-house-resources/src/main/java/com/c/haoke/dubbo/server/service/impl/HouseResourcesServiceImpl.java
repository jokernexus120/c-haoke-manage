package com.c.haoke.dubbo.server.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.service.HouseResourcesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class HouseResourcesServiceImpl extends BaseServiceImpl implements HouseResourcesService {

    @Override
    public int saveHouseResources(HouseResources houseResources) {

        // 添加校验或者是其他的一些逻辑

        if(StringUtils.isBlank(houseResources.getTitle())){
            // 不符合要求
            return -1;
        }

        return super.save(houseResources);
    }
}
