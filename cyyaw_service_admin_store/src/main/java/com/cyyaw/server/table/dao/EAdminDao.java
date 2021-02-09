package com.cyyaw.server.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.EAdmin;
import org.springframework.data.jpa.repository.Query;

public interface EAdminDao extends BaseDao<EAdmin, Integer> {


    @Query("select m from EAdmin m where m.account =?1")
    EAdmin findByAccount(String account);

    @Query("select m from EAdmin m where m.account=?1 and m.enterpriseid =?2")
    EAdmin findByAccountAndEnterpriseid(String account, String code);

    @Query("select m from EAdmin m where m.account=?1 and m.storeid =?2")
    EAdmin findByAccountAndStoreCode(String account, String tid);
}
