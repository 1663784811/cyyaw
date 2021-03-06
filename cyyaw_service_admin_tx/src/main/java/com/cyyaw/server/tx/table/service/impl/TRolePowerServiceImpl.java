package com.cyyaw.server.tx.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.tx.table.service.TRolePowerService;
import com.cyyaw.server.tx.table.dao.TRolePowerDao;
import com.cyyaw.server.tx.table.entity.TRolePower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TRolePowerServiceImpl extends BaseService<TRolePower, Integer> implements TRolePowerService {

    @Autowired
    private TRolePowerDao tRolePowerDao;

    @Override
    public BaseDao getBaseDao() {
        return tRolePowerDao;
    }

}

