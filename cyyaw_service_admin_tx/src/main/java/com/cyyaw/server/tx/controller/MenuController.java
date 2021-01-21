package com.cyyaw.server.tx.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.tx.table.service.MenuService;
import com.cyyaw.server.tx.table.entity.TPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单
 */
@RequestMapping("/tx/admin/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表
     */
    @GetMapping("/getAdminMenu")
    public BaseResult getAdminMenu(
            @RequestParam(value = "admintid", required = false) String admintid
    ){
        List<TPower> list = menuService.getAdminMenu(admintid);
        return BaseResult.ok(list);
    }

    /**
     * 获取菜单列表
     */
    @GetMapping("/getMenuList")
    public BaseResult getMenuList(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "30") Integer size
    ){
        List<TPower> list = menuService.getMenuList(page,size);
        return BaseResult.ok(list);
    }

}