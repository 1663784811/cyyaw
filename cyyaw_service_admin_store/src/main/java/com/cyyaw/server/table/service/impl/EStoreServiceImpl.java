package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EStoreDao;
import com.cyyaw.server.table.entity.EStore;
import com.cyyaw.server.table.service.EStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EStoreServiceImpl extends BaseService<EStore, Integer> implements EStoreService {

    @Autowired
    private EStoreDao eStoreDao;

    @Override
    public BaseDao getBaseDao() {
        return eStoreDao;
    }

}

