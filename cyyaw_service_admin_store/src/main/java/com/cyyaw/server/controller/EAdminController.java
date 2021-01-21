package com.cyyaw.server.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.table.entity.EAdmin;
import com.cyyaw.server.table.service.EAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/store/admin/eadmin")
@RestController
public class EAdminController {


    @Autowired
    private EAdminService eAdminService;

    @RequestMapping("/findByAccount")
    public BaseResult findEAdminByAccount(@RequestParam(value = "account") String account) {
        EAdmin eAdmin = eAdminService.findByAccount(account);
        if (null != eAdmin) {
            return BaseResult.ok(eAdmin);
        } else {
            return BaseResult.fail("用户不存在");
        }
    }


    @RequestMapping("/saveEAdmin")
    public BaseResult saveEAdmin(@RequestBody EAdmin user) {
        String password = user.getPassword();
        String account = user.getAccount();
        if (!StringUtilWHY.isEmpty(password) && !StringUtilWHY.isEmpty(account)) {
            if (StringUtilWHY.isEmpty(user.getTid())) {
                user.setTid(StringUtilWHY.getUUID());
            }
            EAdmin us = eAdminService.save(user);
            return BaseResult.ok(us, "注册成功");
        } else {
            return BaseResult.fail("注册失败");
        }
    }

}
