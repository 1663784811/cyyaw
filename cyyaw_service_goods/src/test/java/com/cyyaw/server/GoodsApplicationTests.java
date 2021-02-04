package com.cyyaw.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.goods.elasticsearch.dao.GoodsSearchDao;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import com.cyyaw.server.goods.table.dao.GDetailsDao;
import com.cyyaw.server.goods.table.dao.GGoodsDao;
import com.cyyaw.server.goods.table.dao.GPhotoDao;
import com.cyyaw.server.goods.table.dao.GSkuDao;
import com.cyyaw.server.goods.table.entity.GDetails;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GPhoto;
import com.cyyaw.server.goods.table.entity.GSku;
import org.checkerframework.checker.units.qual.g;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class GoodsApplicationTests {

    @Autowired
    private JdbcTemplate template;

    /**
     * 添加商品
     * <p>
     * {
     * main:{
     * <p>
     * },
     * photos:[
     * {
     * <p>
     * }
     * ],
     * skus:[
     * {
     * <p>
     * }
     * ],
     * details:[
     * <p>
     * ]
     * }
     */
    @Test
    public void test003() throws InterruptedException {
        for (int m = 0; m < 1000; m++) {
            JSONArray arr = new JSONArray();
            for (int j = 0; j < 1000; j++) {
                JSONObject jsonObject = new JSONObject();
                GGoods goods = GoodsUtils.getGoods();
                jsonObject.put("main", goods);
                List<GPhoto> gPhotos = new ArrayList();
                for (int i = 0; i < 5; i++) {
                    GPhoto gPhoto = GoodsUtils.getGPhoto();
                    gPhotos.add(gPhoto);
                }
                jsonObject.put("photos", gPhotos);

                List<GSku> skus = new ArrayList();
                for (int i = 0; i < 5; i++) {
                    skus.add(GoodsUtils.getGSku());
                }
                jsonObject.put("skus", skus);
                List<GDetails> dl = new ArrayList();
                GDetails gDetails = new GDetails();
                gDetails.setDetails("<p style=\"font-size:30px\">测试</p>");

                dl.add(gDetails);
                jsonObject.put("details", dl);
                arr.add(jsonObject);
            }
            importData(arr);
        }

    }

    /**
     * 导入测试数据
     *
     * @param arr
     */
    private void importData(JSONArray arr) {

        JSONArray goodsList = new JSONArray();
        JSONArray photoList = new JSONArray();
        JSONArray skuList = new JSONArray();
        JSONArray detailsList = new JSONArray();

        for (int m = 0; m < arr.size(); m++) {
            JSONObject json = arr.getJSONObject(m);
            JSONObject main = json.getJSONObject("main");
            JSONArray photos = json.getJSONArray("photos");
            JSONArray skus = json.getJSONArray("skus");
            JSONArray details = json.getJSONArray("details");
            GGoods g = main.toJavaObject(GGoods.class);
            if (null == g.getTid()) {
                g.setTid(StringUtilWHY.getUUID());
            }
            goodsList.add(g);
            // 第二步：添加图片列表
            String tid = g.getTid();
            List<GPhoto> gPhotos = new ArrayList();
            for (int i = 0; i < photos.size(); i++) {
                GPhoto ph = photos.getJSONObject(i).toJavaObject(GPhoto.class);
                ph.setGoodsid(tid);
                gPhotos.add(ph);
            }
            photoList.addAll(gPhotos);
            // 第三步：添加sku
            List<GSku> gSkus = new ArrayList();
            for (int i = 0; i < skus.size(); i++) {
                GSku ph = skus.getJSONObject(i).toJavaObject(GSku.class);
                ph.setGoodsid(tid);
                if (null == ph.getTid()) {
                    ph.setTid(StringUtilWHY.getUUID());
                }
                gSkus.add(ph);
            }
            skuList.addAll(gSkus);
            // 第四步：添加详情
            List<GDetails> gDetails = new ArrayList();
            for (int i = 0; i < details.size(); i++) {
                GDetails ph = details.getJSONObject(i).toJavaObject(GDetails.class);
                ph.setGoodsid(tid);
                gDetails.add(ph);
            }
            detailsList.addAll(gDetails);
        }
//        gGoodsDao.saveAll(goodsList);
//        gPhotoDao.saveAll(photoList);
//        gSkuDao.saveAll(skuList);
//        gDetailsDao.saveAll(detailsList);

        String g_goods = createInsertSql("g_goods", new String[]{
                "brandcode", "enterpriseid", "highprice", "lowprice", "name", "note", "photo", "price", "storeid", "tid", "typecode"
        }, goodsList);
        System.out.println("=============  插入商品表成功");
        template.update(g_goods);

        String g_photo = createInsertSql("g_photo", new String[]{
                "goodsid", "note", "photo"
        }, photoList);
        template.update(g_photo);
        System.out.println("=============  插入图片表成功");

        String g_sku = createInsertSql("g_sku", new String[]{
                "attribute", "enterpriseid", "goodsid", "note", "photo", "price", "storeid", "tid"
        }, skuList);
        template.update(g_sku);
        System.out.println("=============  插入SKU表成功");

        String g_details = createInsertSql("g_details", new String[]{
                "details", "goodsid", "note"
        }, detailsList);
        template.update(g_details);
        System.out.println("=============  插入g_details表成功");

    }


    public String createInsertSql(String table, String[] field, JSONArray data) {
        StringBuffer sb = new StringBuffer("insert into " + table);
        StringBuffer fieldstr = new StringBuffer();
        for (int i = 0; i < field.length; i++) {
            String s = field[i];
            if (i == 0) {
                fieldstr.append("`" + s + "`");
            } else {
                fieldstr.append(",`" + s + "`");
            }
        }
        sb.append(" (" + fieldstr + ") values ");
        for (int i = 0; i < data.size(); i++) {
            JSONObject json = data.getJSONObject(i);
            StringBuffer sbstr = new StringBuffer("");
            if (i == 0) {
                sbstr.append("(");
                for (int j = 0; j < field.length; j++) {
                    String s = field[j];
                    String string = json.getString(s);
                    if (j == 0) {
                        if (string == null) {
                            sbstr.append("NULL");
                        } else {
                            sbstr.append("'" + string + "'");
                        }
                    } else {
                        if (string == null) {
                            sbstr.append(",NULL");
                        } else {
                            sbstr.append(",'" + string + "'");
                        }
                    }
                }
                sbstr.append(")");

            } else {
                sbstr.append(",(");
                for (int j = 0; j < field.length; j++) {
                    String s = field[j];
                    String string = json.getString(s);
                    if (j == 0) {
                        if (string == null) {
                            sbstr.append("NULL");
                        } else {
                            sbstr.append("'" + string + "'");
                        }
                    } else {
                        if (string == null) {
                            sbstr.append(",NULL");
                        } else {
                            sbstr.append(",'" + string + "'");
                        }
                    }
                }
                sbstr.append(")");
            }
            sb.append(sbstr);
        }
        sb.append(";");
        return sb.toString();
    }


}
