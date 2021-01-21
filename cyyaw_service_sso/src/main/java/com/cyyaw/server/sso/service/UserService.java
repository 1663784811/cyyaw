package com.cyyaw.server.sso.service;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "cyyaw-service-user")
public interface UserService {


    @RequestMapping(value = "/user/findUserByAccount" ,produces = "application/json; charset=UTF-8")
    BaseResult findUserByAccount(@RequestParam(value = "account") String account);


    @RequestMapping(value = "/user/saveUser" ,produces = "application/json; charset=UTF-8")
    BaseResult saveUser(@RequestBody JSONObject json);

}
