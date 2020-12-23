package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.sso.table.service.TPowerService;
import com.cyyaw.server.sso.table.table.dao.TPowerDao;
import com.cyyaw.server.sso.table.table.entity.TPower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TPowerServiceImpl extends BaseService<TPower, Integer> implements TPowerService {

    @Autowired
    private TPowerDao tPowerDao;

    @Override
    public BaseDao getBaseDao() {
        return tPowerDao;
    }

}

