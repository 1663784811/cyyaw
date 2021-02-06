package com.cyyaw.web.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/store/admin/role/findRoleList" ,produces = "application/json; charset=UTF-8")
    BaseResult findRoleList(@RequestParam("page") Integer page,@RequestParam("size") Integer size);

    @RequestMapping(value = "/store/admin/role/saveRole" ,produces = "application/json; charset=UTF-8")
    BaseResult saveRole(@RequestBody JSONObject json);

    @RequestMapping(value = "/store/admin/enterprise/findPage" ,produces = "application/json; charset=UTF-8")
    BaseResult findPageEnterprise(@RequestParam("page") Integer page,@RequestParam("size") Integer size);

    @RequestMapping(value = "/store/admin/enterprise/saveEEnterprise" ,produces = "application/json; charset=UTF-8")
    BaseResult saveEEnterprise(@RequestBody  JSONObject json);
}
