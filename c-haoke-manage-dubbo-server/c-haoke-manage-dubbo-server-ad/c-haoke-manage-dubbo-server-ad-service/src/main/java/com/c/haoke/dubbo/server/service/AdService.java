package com.c.haoke.dubbo.server.service;

import com.c.haoke.dubbo.server.pojo.Ad;
import com.c.haoke.dubbo.server.vo.PageInfo;

public interface AdService {

    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);

}
