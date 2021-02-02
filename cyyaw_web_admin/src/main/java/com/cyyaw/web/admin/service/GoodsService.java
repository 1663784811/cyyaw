package com.cyyaw.web.admin.service;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cyyaw-service-goods")
public interface GoodsService {


    @RequestMapping(value = "/goods/goods/search", produces = "application/json; charset=UTF-8")
    BaseResult search(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "search", required = false) String search
    );

    @RequestMapping(value = "/goods/details/goodsInfo", produces = "application/json; charset=UTF-8")
    BaseResult goodsInfo(@RequestParam(value = "goodsid") String goodsid);

    @RequestMapping(value = "/goods/details/findByGoodsid", produces = "application/json; charset=UTF-8")
    BaseResult findDetailsByGoodsid(@RequestParam(value = "goodsid") String goodsid);

    @RequestMapping(value = "/goods/depository/findDepositoryList", produces = "application/json; charset=UTF-8")
    BaseResult findDepositoryList(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @RequestMapping(value = "/goods/depository/saveDepository", produces = "application/json; charset=UTF-8")
    BaseResult saveDepository(@RequestBody JSONObject json);


    @RequestMapping(value = "/goods/goods/findPage", produces = "application/json; charset=UTF-8")
    BaseResult findGoods(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "search") String search
    );

    @RequestMapping(value = "/goods/storegoods/findPage", produces = "application/json; charset=UTF-8")
    BaseResult findShopGoods(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "search") String search
    );


    @RequestMapping(value = "/goods/brand/findPage", produces = "application/json; charset=UTF-8")
    BaseResult findPageBrand(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "search") String search
    );

    @RequestMapping(value = "/goods/type/findPage", produces = "application/json; charset=UTF-8")
    BaseResult findPageType(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "search") String search
    );

    @RequestMapping(value = "/goods/type/saveType", produces = "application/json; charset=UTF-8")
    BaseResult saveType(@RequestBody JSONObject json);


    @RequestMapping(value = "/goods/brand/saveBrand", produces = "application/json; charset=UTF-8")
    BaseResult saveBrand(@RequestBody JSONObject json);


}
