package com.cyyaw.server.tx.table.dao;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.tx.table.entity.TAdmin;
import org.springframework.data.jpa.repository.Query;

public interface TAdminDao extends BaseDao<TAdmin, Integer> {


    @Query("select m from TAdmin m where m.account = ?1")
    TAdmin findByAccount(String account);
}
