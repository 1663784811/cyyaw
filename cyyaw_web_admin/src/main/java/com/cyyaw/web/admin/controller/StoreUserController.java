package com.cyyaw.web.admin.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.JwtTokenUtils;
import com.cyyaw.web.admin.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/store/user")
@RestController
public class StoreUserController {

    @Autowired
    private MyOrderService myOrderService;


    @RequestMapping("/myOrder")
    public BaseResult myOrder(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search,
            HttpServletRequest request
    ) {
        String token = request.getHeader("token");
        String tid = JwtTokenUtils.getId(token);
        return myOrderService.orderList(tid, search, page, size);
    }

}
