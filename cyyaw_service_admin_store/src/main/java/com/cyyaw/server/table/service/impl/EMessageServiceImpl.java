package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EMessageDao;
import com.cyyaw.server.table.entity.EMessage;
import com.cyyaw.server.table.service.EMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EMessageServiceImpl extends BaseService<EMessage, Integer> implements EMessageService {

    @Autowired
    private EMessageDao eMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return eMessageDao;
    }

}

