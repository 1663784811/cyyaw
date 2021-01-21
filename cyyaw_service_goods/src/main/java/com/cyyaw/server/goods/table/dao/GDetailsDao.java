package com.cyyaw.server.goods.table.dao;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.goods.table.entity.GDetails;

import java.util.List;

public interface GDetailsDao extends BaseDao<GDetails, Integer> {


    List<GDetails> findByGoodsid(String goodsid);

}
