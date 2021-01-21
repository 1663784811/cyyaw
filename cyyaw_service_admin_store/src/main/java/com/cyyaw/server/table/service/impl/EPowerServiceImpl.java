package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EPowerDao;
import com.cyyaw.server.table.entity.EPower;
import com.cyyaw.server.table.service.EPowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EPowerServiceImpl extends BaseService<EPower, Integer> implements EPowerService {

    @Autowired
    private EPowerDao ePowerDao;

    @Override
    public BaseDao getBaseDao() {
        return ePowerDao;
    }

}

