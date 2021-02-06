package com.cyyaw.server.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.table.entity.EEnterprise;

public interface EEnterpriseService extends BaseTableService<EEnterprise, Integer> {


    EEnterprise saveEnterprise(EEnterprise eEnterprise);

}
