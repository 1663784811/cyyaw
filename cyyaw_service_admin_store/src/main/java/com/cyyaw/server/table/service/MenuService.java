package com.cyyaw.server.table.service;

import com.cyyaw.server.table.entity.EPower;

import java.util.List;

public interface MenuService {

    List<EPower> getMenuList(EPower ePower);

    List<EPower> getAdminMenu(String tid,String role);

    EPower save(EPower ePower);

    void delMenu(EPower ePower);
}
