package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.ERolePowerDao;
import com.cyyaw.server.table.entity.ERolePower;
import com.cyyaw.server.table.service.ERolePowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ERolePowerServiceImpl extends BaseService<ERolePower, Integer> implements ERolePowerService {

    @Autowired
    private ERolePowerDao eRolePowerDao;

    @Override
    public BaseDao getBaseDao() {
        return eRolePowerDao;
    }

}

