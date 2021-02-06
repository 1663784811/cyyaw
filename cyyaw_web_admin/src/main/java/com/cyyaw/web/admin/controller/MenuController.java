package com.cyyaw.web.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tx/admin/menu")
@RestController
public class MenuController {


    @Autowired
    private MenuService menuService;


    @RequestMapping("/getAdminMenu")
    public BaseResult getAdminMenu(String adminid){
        return  menuService.getAdminMenu(adminid);
    }




    @RequestMapping("/getMenuList")
    public BaseResult getMenuList(Integer page, Integer size){
        return  menuService.getMenuList(page,size);
    }


    @RequestMapping("/updateMenu")
    public BaseResult updateMenu(@RequestBody JSONObject json){
        return  menuService.updateMenu(json);
    }


}
