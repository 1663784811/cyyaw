package com.cyyaw.server;

import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsServiceImplTest {


    @Autowired
    private GoodsService goodsService;



    @Test
    public void test01(){
        goodsService.importElasticSearch();
    }





}
