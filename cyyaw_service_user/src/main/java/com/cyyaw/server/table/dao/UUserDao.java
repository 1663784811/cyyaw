package com.cyyaw.server.table.dao;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.UUser;
import org.springframework.data.jpa.repository.Query;


public interface UUserDao extends BaseDao<UUser, Integer> {


    @Query("select m from UUser m where m.account = ?1")
    UUser findByAccount(String account);

}
