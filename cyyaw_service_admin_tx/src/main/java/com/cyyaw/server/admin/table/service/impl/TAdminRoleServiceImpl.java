package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.TAdminRoleService;
import com.cyyaw.server.admin.table.table.dao.TAdminRoleDao;
import com.cyyaw.server.admin.table.table.entity.TAdminRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TAdminRoleServiceImpl extends BaseService<TAdminRole, Integer> implements TAdminRoleService {

    @Autowired
    private TAdminRoleDao tAdminRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminRoleDao;
    }

}

