package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EDictionaryDao;
import com.cyyaw.server.table.entity.EDictionary;
import com.cyyaw.server.table.service.EDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EDictionaryServiceImpl extends BaseService<EDictionary, Integer> implements EDictionaryService {

    @Autowired
    private EDictionaryDao eDictionaryDao;

    @Override
    public BaseDao getBaseDao() {
        return eDictionaryDao;
    }

}

