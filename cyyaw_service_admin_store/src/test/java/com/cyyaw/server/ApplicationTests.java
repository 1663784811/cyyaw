package com.cyyaw.server;

import com.cyyaw.server.dao.MenuDao;
import com.cyyaw.server.table.service.MenuService;
import com.cyyaw.server.table.entity.EPower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuDao menuDao;

    @Test
    public void test001() {
        for(int i=0;i<13;i++){
            EPower ePower = new EPower();
            //ePower.setCreatetime(new Date());
//            ePower.setTid("c46f08b7ddab4635bc116aedf73c4b29");
            //ePower.setDel(0);
            ePower.setName("名称");
            ePower.setPowertype(0);
//            ePower.setPid("cc43af442e924231a9b8acf11ff7fd82");
            menuService.save(ePower);
        }


    }


    @Test
    public void test002(){
        String s = menuDao.maxPid("002001");
        System.out.println(":::"+s);
    }


}
