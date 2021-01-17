package com.cyyaw.reptiles.table.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.reptiles.table.dao.RReptilesurlDao;
import com.cyyaw.reptiles.table.entity.RReptilesurl;
import com.cyyaw.reptiles.table.service.RReptilesurlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RReptilesurlServiceImpl extends BaseService<RReptilesurl, Integer> implements RReptilesurlService {

    @Autowired
    private RReptilesurlDao rReptilesurlDao;

    @Override
    public BaseDao getBaseDao() {
        return rReptilesurlDao;
    }

    @Override
    public RReptilesurl saveReptilesurl(RReptilesurl rReptilesurl) {
        String url = rReptilesurl.getUrl();
        if (rReptilesurlDao.urlCount(rReptilesurl.getUrl()) > 0) {
            List<RReptilesurl> list = rReptilesurlDao.findByUrl(url);
            return list.size() > 0 ? list.get(0) : null;
        } else {
            rReptilesurl.setCreatetime(new Date());
            rReptilesurl.setTid(StringUtilWHY.getUUID());
            return rReptilesurlDao.save(rReptilesurl);
        }
    }
}

