package com.cyyaw.web.admin.service;

import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("cyyaw-service-store")
public interface StoreService {

    @RequestMapping(value = "/store/admin/menu/getMenuList" ,produces = "application/json; charset=UTF-8")
    BaseResult getMenuList();

    @RequestMapping(value = "/store/admin/menu/getAdminMenu" ,produces = "application/json; charset=UTF-8")
    BaseResult getMenu();

    @RequestMapping(value = "/store/admin/menu/updateMenu" ,produces = "application/json; charset=UTF-8")
    BaseResult updateMenu(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/store/admin/menu/delMenu" ,produces = "application/json; charset=UTF-8")
    BaseResult delMenu(@RequestBody Map<String, Object> map);
}
