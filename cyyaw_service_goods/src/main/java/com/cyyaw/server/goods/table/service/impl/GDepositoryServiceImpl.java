package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.elasticsearch.entity.GoodsList;
import com.cyyaw.server.goods.table.dao.GDepositoryDao;
import com.cyyaw.server.goods.table.entity.GDepository;
import com.cyyaw.server.goods.table.service.GDepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class GDepositoryServiceImpl extends BaseService<GDepository, Integer> implements GDepositoryService {

    @Autowired
    private GDepositoryDao gDepositoryDao;

    @Override
    public BaseDao getBaseDao() {
        return gDepositoryDao;
    }


    @Override
    public BaseResult findDepositoryList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<GDepository> all = gDepositoryDao.findAll(pageable);
        List<GDepository> content = all.getContent();
        long total = all.getTotalElements();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));

    }
}

