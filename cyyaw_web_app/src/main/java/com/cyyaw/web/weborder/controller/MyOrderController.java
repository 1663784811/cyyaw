package com.cyyaw.web.weborder.controller;


import com.cyyaw.web.weborder.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyOrderController {

    @Autowired
    private MyOrderService myOrderServicel;


    @RequestMapping
    public void orderList(){
        String uid = "";
        myOrderServicel.orderList(uid);

    }


}
