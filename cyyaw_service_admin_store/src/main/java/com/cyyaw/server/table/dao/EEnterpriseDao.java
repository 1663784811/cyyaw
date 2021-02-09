package com.cyyaw.server.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.EEnterprise;
import org.springframework.data.jpa.repository.Query;

public interface EEnterpriseDao extends BaseDao<EEnterprise, Integer> {


    @Query("select m from EEnterprise m where m.code = ?1")
    EEnterprise findByCode(String code);
}
