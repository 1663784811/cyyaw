package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.UUserDao;
import com.cyyaw.server.table.entity.UUser;
import com.cyyaw.server.table.service.UUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public UUser findByAccount(String account) {
        return uUserDao.findByAccount(account);
    }
}

