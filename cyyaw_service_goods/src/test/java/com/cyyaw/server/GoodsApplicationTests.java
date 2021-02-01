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
import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class GoodsApplicationTests {

    @Autowired
    private GoodsService goodsService;

    /**
     * 添加商品
     *
     * {
     *     main:{
     *
     *     },
     *     photos:[
     *          {
     *
     *          }
     *     ],
     *     skus:[
     *          {
     *
     *          }
     *     ],
     *     details:[
     *
     *     ]
     * }
     *
     *
     */
    @Test
    public void test003() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(8);
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        new Thread(()->{
            for(int j=0;j<30000;j++){
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
            count.countDown();
        }).start();
        count.await();
    }


}
