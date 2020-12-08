package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.TPhotoService;
import com.cyyaw.server.admin.table.table.dao.TPhotoDao;
import com.cyyaw.server.admin.table.table.entity.TPhoto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TPhotoServiceImpl extends BaseService<TPhoto, Integer> implements TPhotoService {

    @Autowired
    private TPhotoDao tPhotoDao;

    @Override
    public BaseDao getBaseDao() {
        return tPhotoDao;
    }

}

