package com.cyyaw.server.tx.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.tx.table.entity.TAdmin;

public interface TAdminService extends BaseTableService<TAdmin, Integer> {


    TAdmin findByAccount(String account);
}
