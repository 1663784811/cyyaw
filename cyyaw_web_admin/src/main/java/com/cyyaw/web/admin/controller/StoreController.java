package com.cyyaw.web.admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/store/admin")
@RestController
public class StoreController {


    @Autowired
    private StoreService storeService;

    @GetMapping("/menu/getMenuList")
    public BaseResult getMenuList() {
        return storeService.getMenuList();
    }

    @GetMapping("/menu/getAdminMenu")
    public BaseResult getMenu() {
        return storeService.getMenu();
    }

    @PostMapping("/menu/updateMenu")
    public BaseResult updateMenu(@RequestBody Map<String, Object> map) {
        return storeService.updateMenu(map);
    }


    @PostMapping("/menu/delMenu")
    public BaseResult delMenu(@RequestBody Map<String, Object> map) {
        return storeService.delMenu(map);
    }


    @GetMapping("/enterprise/findPage")
    public BaseResult findPageEnterprise(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return storeService.findPageEnterprise(page, size);
    }

    @PostMapping("/enterprise/saveEEnterprise")
    public BaseResult saveEEnterprise(@RequestBody JSONObject json) {
        return storeService.saveEEnterprise(json);
    }

    @PostMapping("/enterprise/delEEnterprise")
    public BaseResult delEEnterprise(@RequestBody JSONArray arr) {
        return storeService.delEEnterprise(arr);
    }

    @GetMapping("/store/findPage")
    public BaseResult findPageStore(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return storeService.findPageStore(page, size);
    }

    @PostMapping("/store/saveStore")
    public BaseResult saveStore(@RequestBody JSONObject json) {
        return storeService.saveStore(json);
    }
}
