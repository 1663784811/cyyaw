package com.cyyaw.server;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.util.BigDecimalUtilsWHY;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GPhoto;
import com.cyyaw.server.goods.table.entity.GSku;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GoodsUtils {


    private static String[] photos={
            "https://img11.360buyimg.com/n1/s200x200_jfs/t1/125694/4/12926/193438/5f64172cE57cb2df2/b85d2e3a8242ec12.jpg",
            "https://img13.360buyimg.com/n1/s200x200_jfs/t1/133756/40/1519/140962/5ed9eb6aEb6019b79/0517e745e98e2651.jpg",
            "https://img14.360buyimg.com/n1/s200x200_jfs/t1/148818/30/16311/135337/5fc449efE0eca205f/9e7fe98c3a2c3705.jpg",
            "https://img14.360buyimg.com/n7/jfs/t1/134740/26/11967/92060/5f843e70E8005bcb6/bb4d854e230a6b2c.jpg",
            "https://img14.360buyimg.com/n7/jfs/t1/140766/38/19932/167143/5fe43196E5b09e32f/c8ed2b47eec1c6ad.jpg",
            "https://img14.360buyimg.com/n0/jfs/t1/158294/24/4727/144892/600bede3E7f2747dc/8a5b58336d7e78ed.jpg",
            "https://img14.360buyimg.com/n0/jfs/t1/136682/4/1564/166959/5eda38f6Ebc58ba10/579ac6a5fd63ec1e.jpg",
            "https://img14.360buyimg.com/n0/jfs/t1/82215/18/9219/98477/5d70a0b5Ede188805/a014c46a4b3d11a2.jpg"
    };
    private static String names="哈登这天只有3次失误，可是最后一次失误是把球“传”给了考文顿，是不是在他的印象中，考文顿还是自己人呢？只打了一场球的哈登以44分列在得分榜第一，但在他身后，是两战平均36.5分的特雷·扬。这个赛季，美国媒体预测谁将是最终的得分王，哈登仍居第一，第二到第四分别是东切奇、布克和特雷·扬然而现在势头最猛的是特雷·扬。当哈登的肥皂剧一出接一出时，特雷·扬已经开始抢班夺权，在蝉联三届得分王后，大胡子的这一位置受到了来自东部新鹰王的挑战。每个时代，新人换旧人都是永恒不变的话题。";

    private static Map<String,String[]> attr = new HashMap<>();

    static {
        String[] color = {"蓝色","黑色","白色","烟紫(素皮)"};
        attr.put("选择颜色", color);
        String[] c = {"全网通 8GB+128GB","全网通 12GB+256GB","全网通 8GB+256GB"};
        attr.put("选择版本", c);
        String[] cd = {"大","中","小"};
        attr.put("大小", cd);
    }



    /**
     * 生成一个商品
     */
    public static GGoods getGoods(){
        int index = new Random().nextInt(photos.length - 1);
        BigDecimal price = BigDecimalUtilsWHY.random(new BigDecimal("0"), new BigDecimal("1000"));
        GGoods goods = new GGoods();
        goods.setCreatetime(new Date());
        goods.setTid(StringUtilWHY.getUUID());
        goods.setHighprice(price);
        goods.setPrice(price);
        goods.setName(StringUtilWHY.getRandomString(15, names));
        goods.setBrandcode("dss");
        goods.setTypecode("seefeifeifnji");
        goods.setPhoto(photos[index]);
        return goods;
    }


    public static GPhoto getGPhoto(){
        int index = new Random().nextInt(photos.length - 1);
        GPhoto gPhoto = new GPhoto();
        gPhoto.setPhoto(photos[index]);
        return gPhoto;
    }


    public static GSku getGSku() {
        int index = new Random().nextInt(photos.length - 1);
        BigDecimal price = BigDecimalUtilsWHY.random(new BigDecimal("0"), new BigDecimal("1000"));
        GSku gSku = new GSku();
        gSku.setPhoto(photos[index]);
        gSku.setAttribute(getSkuAttribute());
        gSku.setPrice(price);
        return gSku;
    }


    public static String getSkuAttribute(){
        JSONObject js = new JSONObject();
        for(String key : attr.keySet()){
            String[] s = attr.get(key);
            int index = new Random().nextInt(s.length - 1);
            js.put(key, s[index]);
        }
        return js.toJSONString();
    }
}
