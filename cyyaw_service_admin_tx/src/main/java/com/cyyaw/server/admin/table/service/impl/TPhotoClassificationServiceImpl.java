package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.TPhotoClassificationService;
import com.cyyaw.server.admin.table.table.dao.TPhotoClassificationDao;
import com.cyyaw.server.admin.table.table.entity.TPhotoClassification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TPhotoClassificationServiceImpl extends BaseService<TPhotoClassification, Integer> implements TPhotoClassificationService {

    @Autowired
    private TPhotoClassificationDao tPhotoClassificationDao;

    @Override
    public BaseDao getBaseDao() {
        return tPhotoClassificationDao;
    }

}

