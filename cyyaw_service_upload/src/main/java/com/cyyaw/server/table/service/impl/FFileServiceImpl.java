package com.cyyaw.server.table.service.impl;



import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.FFileDao;
import com.cyyaw.server.table.entity.FFile;
import com.cyyaw.server.table.service.FFileService;
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
public class FFileServiceImpl extends BaseService<FFile, Integer> implements FFileService {

    @Autowired
    private FFileDao fFileDao;

    @Override
    public BaseDao getBaseDao() {
        return fFileDao;
    }

    @Override
    public BaseResult findFileList(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<FFile> all = fFileDao.findAll(pageable);
        List<FFile> content = all.getContent();
        long total = all.getTotalElements();
        return BaseResult.ok(content, new BaseResult.Result(page,size, total));
    }
}

