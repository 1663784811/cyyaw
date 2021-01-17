package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GGoodsDao;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.service.GGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GGoodsServiceImpl extends BaseService<GGoods, Integer> implements GGoodsService {

    @Autowired
    private GGoodsDao gGoodsDao;

    @Override
    public BaseDao getBaseDao() {
        return gGoodsDao;
    }

}

