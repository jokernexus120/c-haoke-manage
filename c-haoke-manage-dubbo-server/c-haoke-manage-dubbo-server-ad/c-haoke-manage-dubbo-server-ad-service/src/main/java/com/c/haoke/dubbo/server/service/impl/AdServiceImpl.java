package com.c.haoke.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.c.haoke.dubbo.server.pojo.Ad;
import com.c.haoke.dubbo.server.service.AdService;
import com.c.haoke.dubbo.server.serviceimpl.BaseServiceImpl;
import com.c.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {

    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {

        QueryWrapper<Ad> adQueryWrapper = new QueryWrapper<>();
        adQueryWrapper.eq("type",ad.getType());
        adQueryWrapper.orderByDesc("updated");

        IPage<Ad> adIPage = super.queryPageList(page,pageSize,adQueryWrapper);

        PageInfo<Ad> adPageInfo = new PageInfo<Ad>(Long.valueOf(adIPage.getTotal()).intValue(),page,pageSize,adIPage.getRecords());



        return adPageInfo;
    }
}
