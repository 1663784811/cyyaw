package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EAdminPowerDao;
import com.cyyaw.server.table.entity.EAdminPower;
import com.cyyaw.server.table.service.EAdminPowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EAdminPowerServiceImpl extends BaseService<EAdminPower, Integer> implements EAdminPowerService {

    @Autowired
    private EAdminPowerDao eAdminPowerDao;

    @Override
    public BaseDao getBaseDao() {
        return eAdminPowerDao;
    }

}

