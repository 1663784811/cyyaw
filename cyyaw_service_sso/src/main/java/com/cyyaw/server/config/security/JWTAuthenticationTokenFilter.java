package com.cyyaw.server.config.security;

import com.cyyaw.common.util.JwtTokenUtils;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.config.security.entity.UserInfo;
import com.cyyaw.server.sso.redis.TokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@Slf4j
@Component
public class JWTAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    private TokenRepository tokenRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中的token值
        String token = request.getHeader("token");
        if (!StringUtilWHY.isEmpty(token)) {
            boolean isok = JwtTokenUtils.verifierToken(token);
            if (isok) {
                Optional<UserInfo> userInfo = tokenRepository.findById(token);
                if (userInfo.isPresent()) {
                    UserInfo user = userInfo.get();
                    String account = user.getAccount();
                    Collection<JaasGrantedAuthority> rol = new ArrayList<>();

                    UsernamePasswordAuthenticationToken ut = new UsernamePasswordAuthenticationToken(account, null, rol);
                    SecurityContextHolder.getContext().setAuthentication(ut);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
