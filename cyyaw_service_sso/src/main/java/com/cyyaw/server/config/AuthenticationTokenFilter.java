package com.cyyaw.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
public class AuthenticationTokenFilter  extends OncePerRequestFilter {







    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中的token值
        String token = request.getHeader("token");
        if (token != null) {
//            if(token.equals("123456")){
//                // 校验token
//                if (SecurityContextHolder.getContext().getAuthentication() == null) {
//                    // TODO: 后面从Redis缓存中获取，不然每次请求都会去查询用户
//                    JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
//                    if (jwtTokenUtils.validateToken(token, jwtUser)) {
//                        log.info("token有效");
//                        UsernamePasswordAuthenticationToken au = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
//                        //au.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//
//
//                        SecurityContextHolder.getContext().setAuthentication(au);
//                    }
//                }
//            }
        }
        filterChain.doFilter(request, response);
    }
}
