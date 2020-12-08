package com.cyyaw.server.admin.tx.service;

import com.cyyaw.server.admin.table.table.entity.TPower;

import java.util.List;

public interface MenuService {
    List<TPower> getAdminMenu(String tid);
}
