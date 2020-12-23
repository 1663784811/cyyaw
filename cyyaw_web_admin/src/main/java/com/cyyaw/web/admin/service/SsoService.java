package com.cyyaw.web.admin.service;

import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("cyyaw-service-sso")
public interface SsoService {

    @RequestMapping(value = "/login/userLoing" ,produces = "application/json; charset=UTF-8")
    BaseResult userLoing(
            @RequestParam("username") String username,
            @RequestParam("password")  String password,
            @RequestParam("checkCode")  String checkCode
    );

    @RequestMapping(value = "/login/adminLoing" ,produces = "application/json; charset=UTF-8")
    BaseResult adminLoing(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("checkCode") String checkCode
    );


    @RequestMapping(value = "/login/logout" ,produces = "application/json; charset=UTF-8")
    BaseResult logout();

}
