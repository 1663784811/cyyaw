package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.UGroupUserDao;
import com.cyyaw.server.table.entity.UGroupUser;
import com.cyyaw.server.table.service.UGroupUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UGroupUserServiceImpl extends BaseService<UGroupUser, Integer> implements UGroupUserService {

    @Autowired
    private UGroupUserDao uGroupUserDao;

    @Override
    public BaseDao getBaseDao() {
        return uGroupUserDao;
    }

}

