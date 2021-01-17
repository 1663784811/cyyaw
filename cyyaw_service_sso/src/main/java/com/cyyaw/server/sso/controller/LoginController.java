package com.cyyaw.server.sso.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.config.RedisUserInfo;
import com.cyyaw.server.sso.table.entity.UUser;
import com.cyyaw.server.sso.table.service.UUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/login")
@RestController
public class LoginController {


    @Autowired
    private UUserService uUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    /**
     */
    @PostMapping("/store/login")
    public BaseResult storeLogin(@RequestBody JSONObject json){
        String account = json.getString("account");
        String password = json.getString("password");

//        List<UUser> users = uUserService.findByAccount(account);
//
//        UsernamePasswordAuthenticationToken ut = new UsernamePasswordAuthenticationToken(account, password);
//        Authentication authentication = authenticationManager.authenticate(ut);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        JwtUser jwtUser = (RedisUserInfo) userDetailsService.loadUserByUsername(username);

        String uuid = StringUtilWHY.getUUID();
        JSONObject js = new JSONObject();
        js.put("token", uuid);
        return BaseResult.ok(js);
    }

    /**
     */
    @PostMapping("/store/register")
    public BaseResult storeRegister(@RequestBody JSONObject json){
        String account = json.getString("account");
        String password = json.getString("password");
        String pwd = passwordEncoder.encode(password);
        UUser uUser = new UUser();
        uUser.setAccount(account);
        uUser.setPassword(pwd);
        uUser.setTid(StringUtilWHY.getUUID());
        UUser s = uUserService.save(uUser);
        return BaseResult.ok("注册成功");
    }







}
