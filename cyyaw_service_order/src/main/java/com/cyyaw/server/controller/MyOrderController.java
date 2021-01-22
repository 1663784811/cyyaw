package com.cyyaw.server.controller;


import com.alibaba.fastjson.JSONArray;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.table.service.OOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class MyOrderController {

    @Autowired
    private OOrderService oOrderService;


    /**
     * 获取我的订单列表
     * @param uid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/myOrderList")
    public BaseResult myOrderList(
            @RequestParam(value = "uid", required = false) String uid,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ){
        JSONArray order = oOrderService.findByUserid(uid, page, size);
        return BaseResult.ok(order);
    }



    /**
     * 获取我的订单列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findOrderList")
    public BaseResult findOrderList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ){
        return oOrderService.findOrderList(page, size);
    }







}