package com.cyyaw.web.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/store/admin/role")
@RestController
public class StoreRoleController {



    @Autowired
    private StoreService storeService;


    @RequestMapping("/findRoleList")
    public BaseResult findRoleList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return storeService.findRoleList(page, size);
    }


    @RequestMapping("/saveRole")
    public BaseResult saveRole(@RequestBody JSONObject json) {
        return storeService.saveRole(json);
    }

}
