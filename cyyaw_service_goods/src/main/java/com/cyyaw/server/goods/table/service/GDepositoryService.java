package com.cyyaw.server.goods.table.service;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.goods.table.entity.GDepository;

public interface GDepositoryService extends BaseTableService<GDepository, Integer> {



    BaseResult findDepositoryList(Integer page, Integer size);
}
