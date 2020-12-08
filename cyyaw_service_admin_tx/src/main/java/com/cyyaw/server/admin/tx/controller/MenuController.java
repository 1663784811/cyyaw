package com.cyyaw.server.admin.tx.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.admin.table.table.entity.TPower;
import com.cyyaw.server.admin.tx.service.MenuService;
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
    public BaseResult getAdminMenu(@RequestParam(value = "admintid", required = false) String admintid){
        List<TPower> list = menuService.getAdminMenu(admintid);
        return BaseResult.ok(list);
    }

}
