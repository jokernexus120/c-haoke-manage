package com.c.haoke.dubbo.server.api.controller;


import com.c.haoke.dubbo.server.api.service.HouseResourcesService;
import com.c.haoke.dubbo.server.api.vo.TableResult;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.c.haoke.dubbo.server.api.vo.IdWorker;

import java.util.Date;

@RequestMapping("/house/resources")
@RestController
public class HouseResourcesController {

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 新增房源
     *
     * @param houseResources json数据
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources) {

        System.out.println("=============RESOURCES===========");



        try {
            boolean bool = this.houseResourcesService.save(houseResources);
            if (bool) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询房源列表
     *
     * @param houseResources
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/searchhouse")
    @ResponseBody
    public ResponseEntity<TableResult> list(HouseResources houseResources,
                                            @RequestParam(name = "currentPage",
                                                    defaultValue = "1") Integer currentPage,
                                            @RequestParam(name = "pageSize",
                                                    defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.houseResourcesService.queryList(houseResources, currentPage,
                pageSize));
    }

    /**
     * test
     *
     * @return
     */
    @GetMapping("/save")
    @ResponseBody
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("ok");
    }

}
