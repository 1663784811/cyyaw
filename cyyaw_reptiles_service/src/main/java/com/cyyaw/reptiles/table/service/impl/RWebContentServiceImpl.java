package com.cyyaw.reptiles.table.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.reptiles.table.dao.RWebContentDao;
import com.cyyaw.reptiles.table.entity.RWebContent;
import com.cyyaw.reptiles.table.service.RWebContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RWebContentServiceImpl extends BaseService<RWebContent, Integer> implements RWebContentService {

    @Autowired
    private RWebContentDao rWebContentDao;

    @Override
    public BaseDao getBaseDao() {
        return rWebContentDao;
    }

    @Override
    public long urlCount(String url) {
        return rWebContentDao.urlCount(url);
    }

    @Override
    public List<RWebContent> saveList(List<RWebContent> list) {
        for (int i = 0; i < list.size(); i++) {
            RWebContent r = list.get(i);
            r.setTid(StringUtilWHY.getUUID());
            r.setCreatetime(new Date());
            list.set(i, r);
        }
        return rWebContentDao.saveAll(list);
    }

    @Override
    public BaseResult findByTid(String tid) {
        RWebContent rWebContent = rWebContentDao.findByTid(tid);
        return BaseResult.ok(rWebContent);
    }

    @Override
    public RWebContent save(RWebContent rWebContent) {
        rWebContent.setTid(StringUtilWHY.getUUID());
        rWebContent.setCreatetime(new Date());
        return rWebContentDao.save(rWebContent);
    }
}

