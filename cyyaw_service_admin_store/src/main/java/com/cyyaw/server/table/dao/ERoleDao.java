package com.cyyaw.server.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.EPower;
import com.cyyaw.server.table.entity.ERole;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ERoleDao extends BaseDao<ERole, Integer> {


    @Query("select m from ERole m where m.tid = ?1")
    ERole findByTid(String tid);

    @Query(value = "select max(substring(m.treecode,-3)) as maxcode from ERole m where coalesce(?1,'') = coalesce(m.pid,'') ")
    String maxPid(String pid);

    @Query("select m from ERole m where length(m.treecode) > ?1 and m.treecode like concat(?2,'%')")
    List<ERole>  findNextNode(Integer l, String oldPtreecode);
}
