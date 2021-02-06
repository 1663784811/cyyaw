package com.cyyaw.server.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.OOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OOrderDao extends BaseDao<OOrder, Integer> {


    @Query("select m from OOrder m where m.userid = ?1")
    List<OOrder> findAllByUserid(String uid, PageRequest of);
}
