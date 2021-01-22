package com.cyyaw.server;


import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.table.entity.OOrder;
import com.cyyaw.server.table.service.OOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class TestBoot {

    @Autowired
    private OOrderService oOrderService;



    @Test
    public void test001(){

        for (int i = 0; i < 20; i++) {


            OOrder oOrder = new OOrder();
            oOrder.setDel(0);
            oOrder.setTid(StringUtilWHY.getUUID());
            oOrder.setOrderno(StringUtilWHY.createOrderNum());
            oOrder.setAmount(new BigDecimal(10));
            oOrder.setCreatetime(new Date());
            oOrder.setStatus("创建");
            oOrder.setType(0);
            oOrderService.save(oOrder);
        }

    }











}
