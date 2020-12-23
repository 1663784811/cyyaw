package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.sso.table.service.TAdminMessageService;
import com.cyyaw.server.sso.table.table.dao.TAdminMessageDao;
import com.cyyaw.server.sso.table.table.entity.TAdminMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TAdminMessageServiceImpl extends BaseService<TAdminMessage, Integer> implements TAdminMessageService {

    @Autowired
    private TAdminMessageDao tAdminMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminMessageDao;
    }

}

