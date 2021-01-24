package com.cyyaw.server.goods.elasticsearch.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.goods.elasticsearch.service.ComputedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 计算商品价格
 */
@RequestMapping("/goods/computed")
@RestController
public class ComputedController {


    @Autowired
    private ComputedService computedService;


    @PostMapping("/computedGoods")
    public BaseResult computedGoods(@RequestBody JSONObject json) {


        computedService.computedGoods(json);
        return BaseResult.ok();
    }


}
