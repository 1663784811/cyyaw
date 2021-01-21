package com.cyyaw.server.sso.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.JwtTokenUtils;
import com.cyyaw.server.sso.redis.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("/login")
@RestController
public class LogOutController {


    @Autowired
    private TokenRepository tokenRepository;


    @RequestMapping("/logout")
    public BaseResult logout(HttpServletRequest request) {
        String tokenstr = request.getHeader("token");
        if (JwtTokenUtils.verifierToken(tokenstr)) {
            tokenRepository.deleteById(tokenstr);
            SecurityContextHolder.clearContext();
        }
        return BaseResult.ok("退出成功");
    }


}
