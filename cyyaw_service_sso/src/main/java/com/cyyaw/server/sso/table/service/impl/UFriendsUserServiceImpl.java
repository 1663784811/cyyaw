package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.sso.table.dao.UFriendsUserDao;
import com.cyyaw.server.sso.table.entity.UFriendsUser;
import com.cyyaw.server.sso.table.service.UFriendsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UFriendsUserServiceImpl extends BaseService<UFriendsUser, Integer> implements UFriendsUserService {

    @Autowired
    private UFriendsUserDao uFriendsUserDao;

    @Override
    public BaseDao getBaseDao() {
        return uFriendsUserDao;
    }

}

