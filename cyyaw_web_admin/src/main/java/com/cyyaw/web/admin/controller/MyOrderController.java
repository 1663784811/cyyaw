package com.cyyaw.web.admin.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/admin/order")
@RestController
public class MyOrderController {

    @Autowired
    private MyOrderService myOrderServicel;


    @RequestMapping("/orderList")
    public BaseResult orderList(){
        String uid = "";
       return  myOrderServicel.orderList();
    }


}
