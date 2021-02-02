package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GTypeDao;
import com.cyyaw.server.goods.table.entity.GType;
import com.cyyaw.server.goods.table.service.GTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GTypeServiceImpl extends BaseService<GType, Integer> implements GTypeService {

    @Autowired
    private GTypeDao gTypeDao;

    @Override
    public BaseDao getBaseDao() {
        return gTypeDao;
    }

    @Override
    public GType saveType(GType gType) {




        return null;
    }
}

