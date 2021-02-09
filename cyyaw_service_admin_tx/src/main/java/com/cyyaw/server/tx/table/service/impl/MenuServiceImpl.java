package com.cyyaw.server.tx.table.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.CommonDao;
import com.cyyaw.server.tx.table.dao.MenuDao;
import com.cyyaw.server.tx.table.service.MenuService;
import com.cyyaw.server.tx.table.entity.TPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {


    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CommonDao commonDao;


    @Override
    public List<TPower> getAdminMenu(String tid) {
        return menuDao.getAdminMenu(tid);
    }

    @Override
    public List<TPower> getMenuList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return menuDao.getMenuList(pageable);
    }

    @Override
    public TPower save(TPower power) {
        JSONArray array = new JSONArray();
        array.add(power);
        JSONArray data = commonDao.update("cyyaw_tx", "t_power", array);
        return data.getObject(0, TPower.class);
    }

    @Override
    public void delMenu(TPower power) {


    }

}
