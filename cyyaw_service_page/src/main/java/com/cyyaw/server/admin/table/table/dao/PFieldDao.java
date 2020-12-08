package com.cyyaw.server.admin.table.table.dao;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.server.admin.table.table.entity.PField;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PFieldDao extends BaseDao<PField, Integer> {


    @Query("select m from PField m where m.componentsid in( :ctidArr ) order by m.sort ")
    List<PField> findByComponentsId(@Param("ctidArr") List<String> ctidArr);
}
