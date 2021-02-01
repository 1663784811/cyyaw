package com.cyyaw.server.goods.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.goods.table.entity.GSku;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GSkuDao extends BaseDao<GSku, Integer> {


    @Query("select m from GSku m where m.goodsid=?1")
    List<GSku> findByGoodsid(String goodsid);


    @Query("select m from GSku m where m.tid in (:tids)")
    List<GSku> findBySkuList(@Param("tids") List<String> list);

    @Query("select m from GSku m where m.goodsid in(:goodsid)")
    List<GSku> findByGoodsidIn(@Param("goodsid") List<String> list);
}
