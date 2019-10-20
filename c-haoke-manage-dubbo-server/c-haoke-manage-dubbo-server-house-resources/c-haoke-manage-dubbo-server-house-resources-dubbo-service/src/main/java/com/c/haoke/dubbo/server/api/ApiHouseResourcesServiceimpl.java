package com.c.haoke.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.service.HouseResourcesService;
import com.c.haoke.dubbo.server.vo.PageInfo;
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

    /**
     * 分页查询房源列表
     *
     * @param page 当前页
     * @param pageSize 页面大小
     * @param queryCondition 查询条件
     * @return
     */
    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {

        PageInfo<HouseResources> pageInfo = houseResourcesService.queryHouseResourcesList(page,pageSize,queryCondition);

        return pageInfo;
    }


}
