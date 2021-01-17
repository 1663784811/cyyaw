package com.cyyaw.reptiles.table.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.jpa.WhyBeanUtils;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.reptiles.table.dao.RImgDao;
import com.cyyaw.reptiles.table.entity.RImg;
import com.cyyaw.reptiles.table.service.RImgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RImgServiceImpl extends BaseService<RImg, Integer> implements RImgService {

    @Autowired
    private RImgDao rImgDao;

    @Override
    public BaseDao getBaseDao() {
        return rImgDao;
    }

    @Override
    public List<RImg> saveList(List<RImg> list) {
        List<RImg> rest = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            RImg r = list.get(i);
            if (null != r.getUrl() && rImgDao.urlCount(r.getUrl()) == 0) {
                r.setTid(StringUtilWHY.getUUID());
                r.setCreatetime(new Date());
                rest.add(rImgDao.save(r));
            }
        }
        return rest;
    }

    @Override
    public BaseResult getImgList(Integer page, Integer size, String search) {
        Pageable of = PageRequest.of(page - 1, size);
        List<RImg> imgList = rImgDao.getImgList(search, of);
        long count = rImgDao.getImgListCount(search);
        BaseResult.Result result = new BaseResult.Result();
        result.setPage(page);
        result.setSize(size);
        result.setTotal(count);
        return BaseResult.ok(imgList, result);
    }
}

