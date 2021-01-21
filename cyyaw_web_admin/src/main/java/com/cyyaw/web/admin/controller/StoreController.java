package com.cyyaw.web.admin.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/store")
@RestController
public class StoreController {


    @Autowired
    private StoreService storeService;

    @GetMapping("/admin/menu/getMenuList")
    public BaseResult getMenuList(){
        return storeService.getMenuList();
    }

    @GetMapping("/admin/menu/getAdminMenu")
    public BaseResult getMenu(){
        return storeService.getMenu();
    }

    @PostMapping("/admin/menu/updateMenu")
    public BaseResult updateMenu(@RequestBody Map<String,Object> map){
        return storeService.updateMenu(map);
    }



    @PostMapping("/admin/menu/delMenu")
    public BaseResult delMenu(@RequestBody Map<String,Object> map){
        return storeService.delMenu(map);
    }





}