package com.cyyaw.server.tx.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.tx.table.service.TAdminPowerService;
import com.cyyaw.server.tx.table.dao.TAdminPowerDao;
import com.cyyaw.server.tx.table.entity.TAdminPower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TAdminPowerServiceImpl extends BaseService<TAdminPower, Integer> implements TAdminPowerService {

    @Autowired
    private TAdminPowerDao tAdminPowerDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminPowerDao;
    }

}

