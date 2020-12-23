package com.cyyaw.web.admin.controller.login;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {


    @Autowired
    private SsoService ssoService;

    /**
     * 用户登录
     */
    @PostMapping("/userLoing")
    public BaseResult userLoing(String username, String password, String checkCode) {
        return  ssoService.userLoing(username,password,checkCode);
    }

    /**
     * 管理员登录
     */
    @PostMapping("/adminLoing")
    public BaseResult adminLoing(String username, String password, String checkCode) {
        return  ssoService.adminLoing(username,password,checkCode);
    }


    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public BaseResult logout() {
        return  ssoService.logout();
    }


}
