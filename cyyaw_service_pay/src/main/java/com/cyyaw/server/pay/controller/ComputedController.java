package com.cyyaw.server.pay.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.pay.service.ComputedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pay")
@RestController
public class ComputedController {

    @Autowired
    private ComputedService computedService;



    /**
     * 计算商品价格
     */
    public void computeGoods(JSONObject json){



        computedService.computeGoods(json);

    }


}
