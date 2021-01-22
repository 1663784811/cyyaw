package com.cyyaw.server.goods.elasticsearch.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/goods/details")
@RestController
public class GoodsDetailsController {


    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goodsInfo")
    public BaseResult goodsInfo(@RequestParam(value = "goodsid") String goodsid){
        JSONObject res = goodsService.goodsInfo(goodsid);
        return BaseResult.ok(res);
    }


}
