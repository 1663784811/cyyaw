package com.cyyaw.server.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.table.entity.EPower;
import com.cyyaw.server.table.entity.ERole;
import com.cyyaw.server.table.service.ERoleService;
import com.cyyaw.server.table.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store/admin/role")
@RestController
public class RoleController {
    @Autowired
    private ERoleService eRoleService;


    @RequestMapping("/findRoleList")
    public BaseResult findRoleList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return eRoleService.findRoleList(page, size);
    }


    @RequestMapping("/saveRole")
    public BaseResult saveRole(@RequestBody ERole eRole) {
        ERole save = eRoleService.save(eRole);
        return BaseResult.ok(save);
    }

}
