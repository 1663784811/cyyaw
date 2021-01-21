package com.cyyaw.server.goods.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.goods.table.entity.GDetails;

import java.util.List;

public interface GDetailsService extends BaseTableService<GDetails, Integer> {


    List<GDetails> findByGoodsid(String goodsid);

}
