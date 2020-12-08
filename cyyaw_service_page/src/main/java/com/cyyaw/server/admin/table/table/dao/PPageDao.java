package com.cyyaw.server.admin.table.table.dao;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.server.admin.table.table.entity.PPage;
import org.springframework.data.jpa.repository.Query;

public interface PPageDao extends BaseDao<PPage, Integer> {

    @Query("select m from PPage m where m.tid = ?1")
    PPage findByTid(String tid);
}
