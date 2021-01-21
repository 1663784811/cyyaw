package com.cyyaw.server.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.table.entity.UUser;
import com.cyyaw.server.table.service.UUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/user")
@RestController
public class UserController {


    @Autowired
    private UUserService uUserService;


    @GetMapping("/findUserByAccount")
    public BaseResult findUserByAccount(@RequestParam(value = "account") String account) {
        UUser user = uUserService.findByAccount(account);
        if (null != user) {
            return BaseResult.ok(user);
        } else {
            return BaseResult.fail();
        }
    }

    @GetMapping("/saveUser")
    public BaseResult saveUser(@RequestBody UUser user) {
        String password = user.getPassword();
        String account = user.getAccount();
        if (!StringUtilWHY.isEmpty(password) && !StringUtilWHY.isEmpty(account)) {
            if (StringUtilWHY.isEmpty(user.getTid())) {
                user.setTid(StringUtilWHY.getUUID());
            }
            UUser us = uUserService.save(user);
            return BaseResult.ok(us, "注册成功");
        } else {
            return BaseResult.fail();
        }
    }


}
