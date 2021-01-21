package com.cyyaw.server.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.table.entity.UUser;


public interface UUserService extends BaseTableService<UUser, Integer> {


    UUser findByAccount(String account);
}
