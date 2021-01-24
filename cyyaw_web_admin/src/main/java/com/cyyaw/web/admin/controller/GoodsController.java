package com.cyyaw.web.admin.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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



    @GetMapping("/details/goodsInfo")
    public BaseResult goodsInfo(@RequestParam(value = "goodsid") String goodsid) {
        return goodsService.goodsInfo(goodsid);
    }


    @GetMapping("/details/findByGoodsid")
    public BaseResult findDetailsByGoodsid(@RequestParam(value = "goodsid") String goodsid) {
        return goodsService.findDetailsByGoodsid(goodsid);
    }


}
