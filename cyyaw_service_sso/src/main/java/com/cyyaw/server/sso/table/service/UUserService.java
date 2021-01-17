package com.cyyaw.server.sso.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.sso.table.entity.UUser;

import java.util.List;

public interface UUserService extends BaseTableService<UUser, Integer> {


    List<UUser> findByAccount(String account);
}
