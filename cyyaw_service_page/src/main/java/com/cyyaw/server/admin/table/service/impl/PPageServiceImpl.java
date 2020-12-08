package com.cyyaw.server.admin.table.service.impl;

import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.PPageService;
import com.cyyaw.server.admin.table.table.dao.PPageDao;
import com.cyyaw.server.admin.table.table.entity.PPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class PPageServiceImpl extends BaseService<PPage, Integer> implements PPageService {

    @Autowired
    private PPageDao pPageDao;

    @Override
    public BaseDao getBaseDao() {
        return pPageDao;
    }

}

