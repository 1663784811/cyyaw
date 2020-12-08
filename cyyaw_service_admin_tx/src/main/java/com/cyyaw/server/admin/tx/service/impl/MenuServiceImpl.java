package com.cyyaw.server.admin.tx.service.impl;


import com.cyyaw.server.admin.tx.dao.MenuDao;
import com.cyyaw.server.admin.tx.service.MenuService;
import com.cyyaw.server.admin.table.table.entity.TPower;
import org.springframework.beans.factory.annotation.Autowired;
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

}
