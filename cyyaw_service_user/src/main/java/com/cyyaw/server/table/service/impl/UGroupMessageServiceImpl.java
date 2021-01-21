package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.UGroupMessageDao;
import com.cyyaw.server.table.entity.UGroupMessage;
import com.cyyaw.server.table.service.UGroupMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UGroupMessageServiceImpl extends BaseService<UGroupMessage, Integer> implements UGroupMessageService {

    @Autowired
    private UGroupMessageDao uGroupMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return uGroupMessageDao;
    }

}

