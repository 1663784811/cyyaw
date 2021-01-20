package com.cyyaw.server.sso.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.JwtTokenUtils;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.config.security.entity.UserInfo;
import com.cyyaw.server.sso.redis.TokenRepository;
import com.cyyaw.server.sso.table.entity.UUser;
import com.cyyaw.server.sso.table.service.UUserService;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/login/store")
@RestController
public class StoreLoginController {


    @Autowired
    private UUserService uUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private TokenRepository tokenRepository;


    /**
     *
     */
    @PostMapping("/login")
    public BaseResult storeLogin(@RequestBody JSONObject json, HttpServletRequest request) {
        String account = json.getString("account");
        String password = json.getString("password");
        String tokenstr = request.getHeader("token");
        String msg = null;
        if (!StringUtilWHY.isEmpty(account) && !StringUtilWHY.isEmpty(password)) {
            List<UUser> users = uUserService.findByAccount(account);
            if (null != users && users.size() == 1) {
                UUser user = users.get(0);
                String pwd = user.getPassword();
                String salt = user.getSalt();
                String tid = user.getTid();
                String name = user.getAccount();
                if (passwordEncoder.matches(password + salt, pwd)) {
                    //
                    if (JwtTokenUtils.verifierToken(tokenstr)) {
                        String id = JwtTokenUtils.getId(tokenstr);
                        if (tid.equals(id)) {
                            tokenRepository.deleteById(tokenstr);
                        }
                    }
                    UsernamePasswordAuthenticationToken ut = new UsernamePasswordAuthenticationToken(account, password);
                    SecurityContextHolder.getContext().setAuthentication(ut);
                    // 生成jwt
                    String token = JwtTokenUtils.createToken(name, tid, "cyyaw_store");
                    // 保存到redis
                    UserInfo us = new UserInfo();
                    us.setToken(token);
                    us.setTid(tid);
                    us.setCreatetime(user.getCreatetime());
                    us.setAccount(account);
                    us.setTruename(user.getTruename());
                    us.setPhone(user.getPhone());
                    us.setNickname(user.getNickname());
                    us.setFace(user.getFace());
                    us.setEmail(user.getFace());
                    us.setIp(user.getIp());
                    us.setLastlogintime(user.getLastlogintime());
                    us.setStatus(user.getStatus());
                    us.setType(user.getType());
                    us.setAdminid(user.getAdminid());
                    us.setBalance(user.getBalance());
                    us.setIntegral(user.getIntegral());
                    // TODO 查权限
                    HashSet<String> role = new HashSet<>();
                    HashSet<String> power = new HashSet<>();
                    us.setRole(role);
                    us.setPower(power);
                    us.setExpiration(new Date().getTime() + 1000 * 60);
                    UserInfo save = tokenRepository.save(us);
                    return BaseResult.ok(save, "登录成功");
                } else {
                    msg = "用户名或密码错误";
                }
            } else {
                msg = "用户名或密码错误";
            }
        } else {
            msg = "用户名或密码不能为空";
        }
        return BaseResult.fail(msg);
    }

    /**
     *
     */
    @PostMapping("/register")
    public BaseResult storeRegister(@RequestBody JSONObject json) {
        String account = json.getString("account");
        String password = json.getString("password");
        if (!StringUtilWHY.isEmpty(account) && !StringUtilWHY.isEmpty(password)) {
            String salt = StringUtilWHY.getUUID();
            String pwd = passwordEncoder.encode(password + salt);
            UUser uUser = new UUser();
            uUser.setAccount(account);
            uUser.setSalt(salt);
            uUser.setPassword(pwd);
            uUser.setTid(StringUtilWHY.getUUID());
            uUser.setBalance(new BigDecimal("0"));
            UUser user = uUserService.save(uUser);
            return BaseResult.ok(user, "注册成功");
        }
        return BaseResult.ok("注册失败");
    }


}
