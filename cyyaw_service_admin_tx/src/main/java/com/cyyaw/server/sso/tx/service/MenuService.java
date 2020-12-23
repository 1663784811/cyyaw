package com.cyyaw.server.sso.tx.service;

import com.cyyaw.server.sso.table.table.entity.TPower;

import java.util.List;

public interface MenuService {
    List<TPower> getAdminMenu(String tid);

    /**
     * 查询菜单列表
     * @param page 30
     * @param size 10
     * @return
     */
    List<TPower> getMenuList(Integer page, Integer size);
}
