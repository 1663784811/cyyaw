package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.ODetailsDao;
import com.cyyaw.server.table.entity.ODetails;
import com.cyyaw.server.table.service.ODetailsService;
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

