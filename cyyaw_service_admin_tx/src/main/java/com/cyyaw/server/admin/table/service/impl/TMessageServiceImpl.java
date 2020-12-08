package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.TMessageService;
import com.cyyaw.server.admin.table.table.dao.TMessageDao;
import com.cyyaw.server.admin.table.table.entity.TMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TMessageServiceImpl extends BaseService<TMessage, Integer> implements TMessageService {

    @Autowired
    private TMessageDao tMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return tMessageDao;
    }

}

