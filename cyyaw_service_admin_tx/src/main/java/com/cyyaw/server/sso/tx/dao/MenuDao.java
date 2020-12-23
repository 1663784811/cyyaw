package com.cyyaw.server.sso.tx.dao;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.server.sso.table.table.entity.TPower;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDao extends BaseDao<TPower, Integer> {


    @Query("select m from TPower m where m.tid in( select t.tpowerid from TAdminPower t where t.tadminid = ?1) or m.ispower = 0 order by m.sort asc ")
    List<TPower> getAdminMenu(String tid);

    @Query("select m from TPower m ")
    List<TPower> getMenuList(Pageable pageable);

}
