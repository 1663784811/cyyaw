package com.cyyaw.server.sso.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.JwtTokenUtils;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.config.security.entity.UserInfo;
import com.cyyaw.server.sso.redis.TokenRepository;
import com.cyyaw.server.sso.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@RequestMapping("/login/store")
@RestController
public class StoreLoginController {


    @Autowired
    private StoreService storeService;

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
            BaseResult baseres = storeService.findUserByAccount(account);
            if (baseres.getCode() != 200) {
                return baseres;
            }
            JSONObject user = JSON.parseObject(JSONObject.toJSONString(baseres.getData()));
            String pwd = user.getString("password");
            String salt = user.getString("salt");
            String tid = user.getString("tid");
            String name = user.getString("account");
            Date createtime = user.getDate("createtime");
            if (passwordEncoder.matches(password + salt, pwd)) {

                if (JwtTokenUtils.verifierToken(tokenstr)) {
                    String id = JwtTokenUtils.getId(tokenstr);
                    if (tid.equals(id)) {
                        tokenRepository.deleteById(tokenstr);
                    }
                }
                // 生成jwt
                String token = JwtTokenUtils.createToken(name, tid, "cyyaw_store");
                // 保存到redis
                UserInfo us = new UserInfo();
                us.setToken(token);
                us.setTid(tid);
                us.setCreatetime(createtime);
                us.setAccount(account);
                us.setTruename(user.getString("truename"));
                us.setPhone(user.getString("phone"));
                us.setNickname(user.getString("nickname"));
                us.setFace(user.getString("face"));
                us.setEmail(user.getString("email"));
                us.setIp(user.getString("ip"));
                us.setLastlogintime(user.getDate("lastlogintime"));
                us.setStatus(user.getInteger("status"));
                us.setType(user.getInteger("type"));
                us.setAdminid(user.getString("adminid"));
                us.setBalance(user.getBigDecimal("balance"));
                us.setIntegral(user.getInteger("integral"));
                // TODO 查角色
                HashSet<String> role = new HashSet<>();
                // TODO 查权限
                HashSet<String> power = new HashSet<>();
                us.setRole(role);
                us.setPower(power);
                us.setExpiration(new Date().getTime() + 1000 * 60);
                UserInfo save = tokenRepository.save(us);
                Collection<JaasGrantedAuthority> rol = new ArrayList<>();
                UsernamePasswordAuthenticationToken ut = new UsernamePasswordAuthenticationToken(account, password, rol);
                SecurityContextHolder.getContext().setAuthentication(ut);
                return BaseResult.ok(save, "登录成功");

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
            json.put("password", pwd);
            json.put("salt", salt);
            return  storeService.saveUser(json);
        } else {
            return BaseResult.ok("注册失败");
        }
    }


}
