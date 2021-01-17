package com.cyyaw.server.sso.table.dao;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.sso.table.entity.UUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UUserDao extends BaseDao<UUser, Integer> {


    @Query("select m from UUser m where m.account = ?1")
    List<UUser> findByAccount(String account);

}
