package com.cyyaw.web.admin.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/store/user/")
@RestController
public class StoreUserController {

    @Autowired
    private MyOrderService myOrderService;


    @RequestMapping("/store/user/myOrder")
    public BaseResult myOrder(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search") String search

    ) {


        return myOrderService.orderList("", search, page, size);
    }

}
