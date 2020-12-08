package com.cyyaw.server.admin.table.table.dao;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.server.admin.table.table.entity.PPageComponents;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PPageComponentsDao extends BaseDao<PPageComponents, Integer> {


    @Query("select m from PPageComponents m where m.pageid = ?1")
    List<PPageComponents> findByPageid(String pageid);
}
