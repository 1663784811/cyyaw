package com.cyyaw.server.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.JwtTokenUtils;
import com.cyyaw.server.table.service.MenuService;
import com.cyyaw.server.table.entity.EPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/store/admin/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表
     */
    @GetMapping("/getMenuList")
    public BaseResult getMenuList(){
        List<EPower> list = menuService.getMenuList();
        return BaseResult.ok(list);
    }

    /**
     * 获取菜单列表
     */
    @GetMapping("/getAdminMenu")
    public BaseResult getAdminMenu(
            HttpServletRequest request
    ){
        String token = request.getHeader("token");
        String role = JwtTokenUtils.getRole(token);
        String admintid = JwtTokenUtils.getId(token);

        List<EPower> list = menuService.getAdminMenu(admintid, role);
        return BaseResult.ok(list);
    }


    /**
     * 更新菜单
     */
    @PostMapping("/updateMenu")
    public BaseResult updateMenu(@RequestBody EPower ePower){
        EPower e = menuService.save(ePower);
        return BaseResult.ok(e);
    }


    /**
     * 删除菜单
     */
    @PostMapping("/delMenu")
    public BaseResult delMenu(@RequestBody EPower ePower){
        menuService.delMenu(ePower);
        return BaseResult.ok();
    }
}
