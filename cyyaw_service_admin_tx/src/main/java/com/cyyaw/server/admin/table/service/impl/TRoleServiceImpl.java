package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.TRoleService;
import com.cyyaw.server.admin.table.table.dao.TRoleDao;
import com.cyyaw.server.admin.table.table.entity.TRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TRoleServiceImpl extends BaseService<TRole, Integer> implements TRoleService {

    @Autowired
    private TRoleDao tRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return tRoleDao;
    }

}

