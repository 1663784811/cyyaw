package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EAdminRoleDao;
import com.cyyaw.server.table.entity.EAdminRole;
import com.cyyaw.server.table.service.EAdminRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EAdminRoleServiceImpl extends BaseService<EAdminRole, Integer> implements EAdminRoleService {

    @Autowired
    private EAdminRoleDao eAdminRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return eAdminRoleDao;
    }

}

