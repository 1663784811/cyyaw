package com.cyyaw.server.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.table.entity.EPower;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDao extends BaseDao<EPower, Integer> {

    @Query("select m from EPower m where m.tid in( select t.powerid from EAdminPower t where t.adminid = ?1) or m.ispower = 0 order by m.sort asc ")
    List<EPower>  getAdminMenu(String tid);


    @Query("select m from EPower m where m.tid = ?1 ")
    EPower findByTid(String tid);

    @Query(value = "select max(substring(m.treecode,-3)) as maxcode from EPower m where coalesce(?1,'') = coalesce(m.pid,'') ")
    String maxPid(String pid);


    @Query("select m from EPower m where length(m.treecode) > ?1 and m.treecode like concat(?2,'%')")
    List<EPower>  findNextNode(Integer l, String oldPtreecode);

}
