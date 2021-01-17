package com.cyyaw.server.goods.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.goods.table.entity.GPhoto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GPhotoDao extends BaseDao<GPhoto, Integer> {


    @Query("select m from GPhoto m where m.goodsid=?1")
    List<GPhoto> findByGoodsid(String goodsid);

}
