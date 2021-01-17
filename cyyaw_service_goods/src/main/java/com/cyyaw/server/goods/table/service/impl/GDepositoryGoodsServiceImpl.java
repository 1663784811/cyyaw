package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GDepositoryGoodsDao;
import com.cyyaw.server.goods.table.entity.GDepositoryGoods;
import com.cyyaw.server.goods.table.service.GDepositoryGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GDepositoryGoodsServiceImpl extends BaseService<GDepositoryGoods, Integer> implements GDepositoryGoodsService {

    @Autowired
    private GDepositoryGoodsDao gDepositoryGoodsDao;

    @Override
    public BaseDao getBaseDao() {
        return gDepositoryGoodsDao;
    }

}

