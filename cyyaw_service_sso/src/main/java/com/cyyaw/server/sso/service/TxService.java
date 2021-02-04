package com.cyyaw.server.sso.service;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cyyaw-service-tx")
public interface TxService {

    @RequestMapping(value = "/tx/admin/findByAccount" ,produces = "application/json; charset=UTF-8")
    BaseResult findAdminByAccount(@RequestParam("account") String account);


    @RequestMapping(value = "/tx/admin/saveAdmin" ,produces = "application/json; charset=UTF-8")
    BaseResult saveAdmin(@RequestBody JSONObject json);

}
