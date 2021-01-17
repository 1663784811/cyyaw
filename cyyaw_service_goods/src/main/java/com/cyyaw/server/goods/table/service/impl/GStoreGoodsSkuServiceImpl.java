package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GStoreGoodsSkuDao;
import com.cyyaw.server.goods.table.entity.GStoreGoodsSku;
import com.cyyaw.server.goods.table.service.GStoreGoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GStoreGoodsSkuServiceImpl extends BaseService<GStoreGoodsSku, Integer> implements GStoreGoodsSkuService {

    @Autowired
    private GStoreGoodsSkuDao gStoreGoodsSkuDao;

    @Override
    public BaseDao getBaseDao() {
        return gStoreGoodsSkuDao;
    }

}

