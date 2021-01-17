package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.sso.table.dao.UUserDao;
import com.cyyaw.server.sso.table.entity.UUser;
import com.cyyaw.server.sso.table.service.UUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UUserServiceImpl extends BaseService<UUser, Integer> implements UUserService {

    @Autowired
    private UUserDao uUserDao;

    @Override
    public BaseDao getBaseDao() {
        return uUserDao;
    }

    @Override
    public List<UUser> findByAccount(String account) {
        return uUserDao.findByAccount(account);
    }
}

