package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.sso.table.dao.UFriendsMessageDao;
import com.cyyaw.server.sso.table.entity.UFriendsMessage;
import com.cyyaw.server.sso.table.service.UFriendsMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UFriendsMessageServiceImpl extends BaseService<UFriendsMessage, Integer> implements UFriendsMessageService {

    @Autowired
    private UFriendsMessageDao uFriendsMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return uFriendsMessageDao;
    }

}

