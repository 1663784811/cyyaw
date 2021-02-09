package com.cyyaw.server.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.table.entity.EAdmin;

public interface EAdminService extends BaseTableService<EAdmin, Integer> {


    EAdmin findByAccount(String account);


    EAdmin findByAccountAndEnterpriseNo(String account,String enterprise, String code);
}
