package com.cyyaw.server.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
import com.cyyaw.server.table.service.OOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
public class MyOrderController {

    @Autowired
    private OOrderService oOrderService;

    /**
     * 生成订单
     *
     * @param json
     * @return
     */
    @PostMapping("/createOrder")
    public BaseResult createOrder(@RequestBody JSONObject json) {
        ComputedRest order = oOrderService.createOrder(json);
        return BaseResult.ok(order);
    }

    /**
     * 获取我的订单列表
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/myOrderList")
    public BaseResult myOrderList(
            @RequestParam(value = "userid") String userid,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return oOrderService.findByUserid(userid, search, page, size);
    }


    /**
     * 获取我的订单列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findOrderList")
    public BaseResult findOrderList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return oOrderService.findOrderList(page, size);
    }


}
