package com.cyyaw.server.goods.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.goods.table.entity.GGoods;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GGoodsDao extends BaseDao<GGoods, Integer> {


    @Query("select m from GGoods m where m.tid in ( :goodsid ) ")
    List<GGoods> findByTidIn(@Param("goodsid") List<String> goodsids);

    @Query("select m from GGoods m where m.tid =?1")
    GGoods findByTid(String tid);

}
