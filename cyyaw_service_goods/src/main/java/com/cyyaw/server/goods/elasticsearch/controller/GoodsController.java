package com.cyyaw.server.goods.elasticsearch.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GSku;
import com.cyyaw.server.goods.table.service.GSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/goods")
@RestController
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GSkuService gSkuService;

    /**
     * 获取我的订单列表
     */
    @GetMapping("/search")
    public BaseResult search(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.search(search, page, size);
    }

    /**
     * 导入 ElasticSearch
     *
     * @return
     */
    @GetMapping("/importElasticSearch")
    public List<GGoods> importElasticSearch() {
        return goodsService.importElasticSearch();
    }

    @PostMapping("/saveGoods")
    public BaseResult saveGoods(@RequestBody JSONObject json) {
        JSONObject obj = goodsService.saveGoods(json);
        return BaseResult.ok(obj);
    }

    @PostMapping("/findSku")
    public List<GSku> findSku(@RequestBody List<String> list) {
        return gSkuService.findBySkuList(list);
    }






}
