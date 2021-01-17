package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GDetailsDao;
import com.cyyaw.server.goods.table.entity.GDetails;
import com.cyyaw.server.goods.table.service.GDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GDetailsServiceImpl extends BaseService<GDetails, Integer> implements GDetailsService {

    @Autowired
    private GDetailsDao gDetailsDao;

    @Override
    public BaseDao getBaseDao() {
        return gDetailsDao;
    }

}

