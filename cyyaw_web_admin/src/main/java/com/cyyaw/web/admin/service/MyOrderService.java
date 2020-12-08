package com.cyyaw.web.admin.service;

import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("cyyaw-order-service")
public interface MyOrderService {

    /**
     * 获取用户订单列表
     */
    @RequestMapping(value = "/order/myOrderList" ,produces = "application/json; charset=UTF-8")
    BaseResult orderList();

}
