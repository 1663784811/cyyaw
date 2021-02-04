package com.cyyaw.server.tx.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.tx.table.entity.TAdmin;
import com.cyyaw.server.tx.table.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tx/admin")
@RestController
public class AdminController {


    @Autowired
    private TAdminService tAdminService;


    @RequestMapping("/findByAccount")
    public BaseResult findByAccount(@RequestParam("account") String account) {
        TAdmin admin = tAdminService.findByAccount(account);
        return BaseResult.ok(admin);
    }


    @RequestMapping("/saveAdmin")
    public BaseResult saveAdmin(@RequestBody TAdmin user){
        String password = user.getPassword();
        String account = user.getAccount();
        if (!StringUtilWHY.isEmpty(password) && !StringUtilWHY.isEmpty(account)) {
            if (StringUtilWHY.isEmpty(user.getTid())) {
                user.setTid(StringUtilWHY.getUUID());
            }
            TAdmin us = tAdminService.save(user);
            return BaseResult.ok(us, "注册成功");
        } else {
            return BaseResult.fail("注册失败");
        }
    }
}
