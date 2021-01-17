package com.cyyaw.server.service;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.table.entity.EPower;

import java.util.List;
import java.util.Map;

public interface MenuService {

    List<EPower> getMenuList();

    List<EPower> getAdminMenu(String admintid);

    EPower save(EPower ePower);

    void delMenu(EPower ePower);
}
