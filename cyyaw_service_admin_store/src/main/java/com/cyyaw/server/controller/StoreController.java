package com.cyyaw.server.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.table.service.MenuService;
import com.cyyaw.server.table.entity.EPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store/admin/menu")
@RestController
public class StoreController {
    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表
     */
    @GetMapping("/getMenuList")
    public BaseResult getMenuList(){
        List<EPower> list = menuService.getMenuList();
        return BaseResult.ok(list);
    }

    /**
     * 获取菜单列表
     */
    @GetMapping("/getAdminMenu")
    public BaseResult getAdminMenu(
            @RequestParam(value = "admintid", required = false) String admintid
    ){
        List<EPower> list = menuService.getAdminMenu(admintid);
        return BaseResult.ok(list);
    }


    /**
     * 更新菜单
     */
    @PostMapping("/updateMenu")
    public BaseResult updateMenu(@RequestBody EPower ePower){
        EPower e = menuService.save(ePower);
        return BaseResult.ok(e);
    }


    /**
     * 删除菜单
     */
    @PostMapping("/delMenu")
    public BaseResult delMenu(@RequestBody EPower ePower){
        menuService.delMenu(ePower);
        return BaseResult.ok();
    }
}
