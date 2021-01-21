package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EAdminMessageDao;
import com.cyyaw.server.table.entity.EAdminMessage;
import com.cyyaw.server.table.service.EAdminMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EAdminMessageServiceImpl extends BaseService<EAdminMessage, Integer> implements EAdminMessageService {

    @Autowired
    private EAdminMessageDao eAdminMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return eAdminMessageDao;
    }

}

