package com.cyyaw.server.sso.service;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cyyaw-service-store")
public interface StoreService {


    @RequestMapping(value = "/store/admin/eadmin/findByAccount" ,produces = "application/json; charset=UTF-8")
    BaseResult findEAdminByAccount(@RequestParam(value = "account") String account);

    @RequestMapping(value = "/store/admin/eadmin/saveEAdmin" ,produces = "application/json; charset=UTF-8")
    BaseResult saveEAdmin(@RequestBody JSONObject json);
}
