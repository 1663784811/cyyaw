package com.cyyaw.server.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.service.ComputedService;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order/compute")
@RestController
public class ComputedController {

    @Autowired
    private ComputedService computedService;



    /**
     * 计算商品价格
     * @return
     */
    @RequestMapping("/computeGoods")
    public BaseResult computeGoods(@RequestBody JSONObject json){
        ComputedRest computedRest = json.toJavaObject(ComputedRest.class);
        ComputedRest rest = computedService.computeGoods(computedRest);
        return BaseResult.ok(rest);
    }


}
