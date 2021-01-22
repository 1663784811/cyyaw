package com.cyyaw.web.admin.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/order")
@RestController
public class MyOrderController {

    @Autowired
    private MyOrderService myOrderServicel;


    @RequestMapping("/orderList")
    public BaseResult orderList(){
       return  myOrderServicel.orderList();
    }

    @RequestMapping("/findOrderList")
    public BaseResult findOrderList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ){
        return  myOrderServicel.findOrderList(page,size);
    }
}
