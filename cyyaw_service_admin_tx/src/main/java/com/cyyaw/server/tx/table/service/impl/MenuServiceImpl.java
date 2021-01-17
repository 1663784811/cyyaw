package com.cyyaw.server.tx.table.service.impl;


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


    @Override
    public List<TPower> getAdminMenu(String tid) {
        return menuDao.getAdminMenu(tid);
    }

    @Override
    public List<TPower> getMenuList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return menuDao.getMenuList(pageable);
    }

}
