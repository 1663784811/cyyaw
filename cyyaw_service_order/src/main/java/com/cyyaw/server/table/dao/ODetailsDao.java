package com.cyyaw.server.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.ODetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ODetailsDao extends BaseDao<ODetails, Integer> {


    @Query("select m from ODetails m where m.orderid in(:orderid)")
    List<ODetails> findByOrderids(@Param("orderid") List<String> orderNo);
}
