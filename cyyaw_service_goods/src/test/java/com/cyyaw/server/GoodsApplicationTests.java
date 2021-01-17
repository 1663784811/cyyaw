package com.cyyaw.server;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import com.cyyaw.server.goods.table.entity.GDetails;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GPhoto;
import com.cyyaw.server.goods.table.entity.GSku;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GoodsApplicationTests {

    @Autowired
    private GoodsService goodsService;

    /**
     * 添加商品
     */
    @Test
    public void test003(){

        for(int j=0;j<10;j++){


            JSONObject jsonObject = new JSONObject();
            GGoods goods = GoodsUtils.getGoods();
            jsonObject.put("main", goods);
            List<GPhoto> gPhotos = new ArrayList();
            for(int i =0;i< 5;i++){
                GPhoto gPhoto = GoodsUtils.getGPhoto();
                gPhotos.add(gPhoto);
            }
            jsonObject.put("photos", gPhotos);


            List<GSku> skus = new ArrayList();
            for(int i =0;i< 5;i++){
                skus.add(GoodsUtils.getGSku());
            }
            jsonObject.put("skus", skus);

            List<GDetails> dl = new ArrayList();
            GDetails gDetails = new GDetails();
            gDetails.setDetails("<p style='font-size:30px'>测试</p>");
            dl.add(gDetails);
            jsonObject.put("details", dl);


            goodsService.saveGoods(jsonObject);

        }





    }


}
