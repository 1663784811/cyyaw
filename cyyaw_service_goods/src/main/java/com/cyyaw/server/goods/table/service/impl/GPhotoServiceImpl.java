package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GPhotoDao;
import com.cyyaw.server.goods.table.entity.GPhoto;
import com.cyyaw.server.goods.table.service.GPhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GPhotoServiceImpl extends BaseService<GPhoto, Integer> implements GPhotoService {

    @Autowired
    private GPhotoDao gPhotoDao;

    @Override
    public BaseDao getBaseDao() {
        return gPhotoDao;
    }

}

