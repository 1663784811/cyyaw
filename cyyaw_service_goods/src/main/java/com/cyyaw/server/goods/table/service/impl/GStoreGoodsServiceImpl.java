package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GStoreGoodsDao;
import com.cyyaw.server.goods.table.entity.GStoreGoods;
import com.cyyaw.server.goods.table.service.GStoreGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GStoreGoodsServiceImpl extends BaseService<GStoreGoods, Integer> implements GStoreGoodsService {

    @Autowired
    private GStoreGoodsDao gStoreGoodsDao;

    @Override
    public BaseDao getBaseDao() {
        return gStoreGoodsDao;
    }

}

