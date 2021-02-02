package com.cyyaw.web.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pc/goods")
@RestController
public class GoodsController {


    @Autowired
    private GoodsService goodsService;


    @GetMapping("/search")
    public BaseResult search(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.search(page, size, search);
    }


    @GetMapping("/findGoods")
    public BaseResult findGoods(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.findGoods(page, size, search);
    }

    @GetMapping("/findShopGoods")
    public BaseResult findShopGoods(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.findShopGoods(page, size, search);
    }


    @GetMapping("/details/goodsInfo")
    public BaseResult goodsInfo(@RequestParam(value = "goodsid") String goodsid) {
        return goodsService.goodsInfo(goodsid);
    }


    @GetMapping("/details/findByGoodsid")
    public BaseResult findDetailsByGoodsid(@RequestParam(value = "goodsid") String goodsid) {
        return goodsService.findDetailsByGoodsid(goodsid);
    }

    @GetMapping("/brand/findPage")
    public BaseResult findPageBrand(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.findPageBrand(page, size, search);
    }

    @GetMapping("/type/findPage")
    public BaseResult findPageType(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.findPageType(page, size, search);
    }



    @GetMapping("/type/saveType")
    public BaseResult saveType(@RequestBody JSONObject json) {
        return goodsService.saveType(json);
    }

    @GetMapping("/brand/saveBrand")
    public BaseResult saveBrand(@RequestBody JSONObject json) {
        return goodsService.saveBrand(json);
    }
}
