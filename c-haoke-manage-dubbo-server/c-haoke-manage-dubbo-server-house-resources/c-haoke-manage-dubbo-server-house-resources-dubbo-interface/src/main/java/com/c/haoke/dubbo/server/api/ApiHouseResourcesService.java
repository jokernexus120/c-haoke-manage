package com.c.haoke.dubbo.server.api;

import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.vo.PageInfo;

public interface ApiHouseResourcesService {

    /**
     * 新增房源
     *
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
     * 根据id查找房源数据    
     *
      * @param id    
     * @return     */

    HouseResources queryHouseResourcesById(Long id);


    /**
     * 更新房源数据
     *
     * @param houseResources
     * @return
     */
    boolean updateHouseResources(HouseResources houseResources);}
