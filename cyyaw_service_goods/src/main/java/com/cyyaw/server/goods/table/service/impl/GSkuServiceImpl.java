package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GSkuDao;
import com.cyyaw.server.goods.table.entity.GSku;
import com.cyyaw.server.goods.table.service.GSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class GSkuServiceImpl extends BaseService<GSku, Integer> implements GSkuService {

    @Autowired
    private GSkuDao gSkuDao;

    @Override
    public BaseDao getBaseDao() {
        return gSkuDao;
    }

    @Override
    public List<GSku> findBySkuList(List<String> list) {
        List<GSku> skus = gSkuDao.findBySkuList(list);
        return skus;
    }
}

