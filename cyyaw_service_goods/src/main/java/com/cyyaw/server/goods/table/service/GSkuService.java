package com.cyyaw.server.goods.table.service;


import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.goods.table.entity.GSku;

import java.util.List;

public interface GSkuService extends BaseTableService<GSku, Integer> {


    List<GSku> findBySkuList(List<String> list);
}
