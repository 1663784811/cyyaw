package com.cyyaw.server.table.service;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.table.entity.ERole;

public interface ERoleService extends BaseTableService<ERole, Integer> {


    BaseResult findRoleList(Integer page, Integer size);

    ERole save(ERole eRole);
}
