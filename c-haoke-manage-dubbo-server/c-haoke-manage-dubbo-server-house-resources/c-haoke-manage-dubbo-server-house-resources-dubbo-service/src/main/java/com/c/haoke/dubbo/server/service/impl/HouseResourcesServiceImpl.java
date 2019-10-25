package com.c.haoke.dubbo.server.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import com.c.haoke.dubbo.server.service.HouseResourcesService;
import com.c.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService  {

    @Override
    public int saveHouseResources(HouseResources houseResources) {

        // 添加校验或者是其他的一些逻辑

        if(StringUtils.isBlank(houseResources.getTitle())){
            // 不符合要求
            return -1;
        }

        return super.save(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {

        QueryWrapper<HouseResources> queryWrapper = new QueryWrapper<>();

        if (queryCondition!=null)
        {
             queryWrapper = new QueryWrapper<>(queryCondition);
        }

        queryWrapper.orderByDesc("updated");

        IPage<HouseResources> iPage = super.queryPageList(page,pageSize,queryWrapper);



        PageInfo<HouseResources> pageInfo = new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
        return pageInfo;
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        if (id!=null)
        {
            return null;
        }

        return super.queryById(id);
    }
}
