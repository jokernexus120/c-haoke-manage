package com.c.haoke.dubbo.server.service;

import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.vo.PageInfo;

public interface HouseResourcesService {

    /**
     * @param houseResources
     *
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);

    /**
     * 分页查询房源列表
     *
     * @param page 当前页
     * @param pageSize 页面大小
     * @param queryCondition 查询条件
     * @return
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize,
                                                     HouseResources queryCondition);

    /**
     * 根据ID搜索房源
     * @param id
     *
     * @return  成功返回HouseResources
     */

    HouseResources queryHouseResourcesById(Long id);

}
