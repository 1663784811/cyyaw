package com.cyyaw.web.admin.service;

import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cyyaw-service-tx")
public interface MenuService {


    @RequestMapping(value = "/tx/admin/menu/getAdminMenu" ,produces = "application/json; charset=UTF-8")
    BaseResult getAdminMenu(
            @RequestParam("adminid") String adminid
    );

    @RequestMapping(value = "/tx/admin/menu/getMenuList" ,produces = "application/json; charset=UTF-8")
    BaseResult getMenuList(@RequestParam("page") Integer page, @RequestParam("size") Integer size);
}
