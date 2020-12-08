package com.cyyaw.web.weborder.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cyyaw-order-service")
public interface MyOrderService {

    /**
     * 获取用户订单列表
     * @param uid
     */
    @GetMapping("/order/myOrderList")
    void orderList(@PathVariable String uid);

}
