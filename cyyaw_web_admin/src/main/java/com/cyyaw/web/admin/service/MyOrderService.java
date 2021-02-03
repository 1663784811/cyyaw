package com.cyyaw.web.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "cyyaw-order-service",
        fallback = AdminServiceFallback.class
)
public interface MyOrderService {

    /**
     * 获取用户订单列表
     */
    @RequestMapping(value = "/order/myOrderList", produces = "application/json; charset=UTF-8")
    BaseResult orderList();

    @RequestMapping(value = "/order/findOrderList", produces = "application/json; charset=UTF-8")
    BaseResult findOrderList(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(value = "/order/compute/computeGoods", produces = "application/json; charset=UTF-8")
    BaseResult computeGoods(@RequestBody JSONObject json);

    @RequestMapping(value = "/order/createOrder", produces = "application/json; charset=UTF-8")
    BaseResult createOrder(JSONObject json);
}
