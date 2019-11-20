package com.c.haoke.dubbo.server.api;

import com.c.haoke.dubbo.server.pojo.Ad;
import com.c.haoke.dubbo.server.vo.PageInfo;

public interface ApiAdService {


    PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize);
}
