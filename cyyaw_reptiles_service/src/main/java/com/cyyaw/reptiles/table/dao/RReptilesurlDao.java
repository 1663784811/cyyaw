package com.cyyaw.reptiles.table.dao;


import cn.cyyaw.jpa.BaseDao;
import com.cyyaw.reptiles.table.entity.RReptilesurl;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RReptilesurlDao extends BaseDao<RReptilesurl, Integer> {


    @Query("select count(m) from RReptilesurl m where m.url=?1")
    long urlCount(String url);

    @Query("select m from RReptilesurl m where m.url=?1")
    List<RReptilesurl> findByUrl(String url);
}
