package com.cyyaw.server.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.EStore;
import org.springframework.data.jpa.repository.Query;

public interface EStoreDao extends BaseDao<EStore, Integer> {


    @Query("select m from  EStore m where m.code = ?1")
    EStore findByCode(String code);
}
