package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.sso.table.service.ODetailsService;
import com.cyyaw.server.sso.table.table.dao.ODetailsDao;
import com.cyyaw.server.sso.table.table.entity.ODetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ODetailsServiceImpl extends BaseService<ODetails, Integer> implements ODetailsService {

    @Autowired
    private ODetailsDao oDetailsDao;

    @Override
    public BaseDao getBaseDao() {
        return oDetailsDao;
    }

}

