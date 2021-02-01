package com.cyyaw.server.goods.elasticsearch.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.WhyBeanUtils;
import com.cyyaw.server.goods.elasticsearch.dao.GoodsSearchDao;
import com.cyyaw.server.goods.elasticsearch.entity.GoodsList;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import com.cyyaw.server.goods.table.dao.GDetailsDao;
import com.cyyaw.server.goods.table.dao.GGoodsDao;
import com.cyyaw.server.goods.table.dao.GPhotoDao;
import com.cyyaw.server.goods.table.dao.GSkuDao;
import com.cyyaw.server.goods.table.entity.GDetails;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GPhoto;
import com.cyyaw.server.goods.table.entity.GSku;
import com.netflix.discovery.converters.Auto;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsSearchDao goodsSearchDao;

    @Autowired
    private GGoodsDao gGoodsDao;
    @Autowired
    private GPhotoDao gPhotoDao;
    @Autowired
    private GSkuDao gSkuDao;
    @Autowired
    private GDetailsDao gDetailsDao;


    @Override
    public BaseResult search(String search, Integer page, Integer size) {


        Pageable pageable = PageRequest.of(
                page - 1, size,
                Sort.by("istop").descending().and(Sort.by("updatetime").descending()).and(Sort.by("evaluate").descending())
        );
        Page<GoodsList> all = goodsSearchDao.findAll(pageable);
        List<GoodsList> content = all.getContent();
        long total = all.getTotalElements();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

    @Override
    public GoodsList save(GoodsList goodsList) {
        return null;
    }


    @Override
    public List<GGoods> importElasticSearch() {
        //总数
        long count = gGoodsDao.count();
        int page = 1;
        int size = 1000;
        double ceil = Math.ceil(count / (double) size);
        for (int i = page - 1; i < ceil; i++) {
            Pageable pageRequest = PageRequest.of(i, size);
            Page<GGoods> all = gGoodsDao.findAll(pageRequest);
            List<GGoods> goodsList = all.getContent();

            List<String> goodsidList = new ArrayList<>();
            for (int j = 0; j < goodsList.size(); j++) {
                GGoods gGoods = goodsList.get(j);
                String tid = gGoods.getTid();
                goodsidList.add(tid);
            }

            List<GSku> gSkuList = gSkuDao.findByGoodsidIn(goodsidList);


            for (int n = 0; n < goodsList.size(); n++) {
                GGoods g = goodsList.get(n);
                GoodsList gl = new GoodsList();
                gl.setTid(g.getTid());
                gl.setName(g.getName());

                String skuid = null;
                BigDecimal price = null;
                BigDecimal lowprice = null;
                BigDecimal highprice = null;

                String gid = g.getTid();

                for (int j = 0; j < gSkuList.size(); j++) {
                    GSku gSku = gSkuList.get(j);
                    String goodsid = gSku.getGoodsid();
                    if (gid.equals(goodsid)) {
                        skuid = gSku.getTid();
                        price = gSku.getPrice();
                        if (lowprice == null || lowprice.compareTo(price) > 0) {
                            lowprice = price;
                        }
                        if (highprice == null || highprice.compareTo(price) < page) {
                            highprice = gSku.getPrice();
                        }
                    }
                }

                gl.setSkuid(skuid);
                gl.setPrice(price);
                gl.setLowprice(lowprice);
                gl.setHighprice(highprice);

                gl.setTypecode(g.getTypecode());
                gl.setBrandcode(g.getBrandcode());
                gl.setPhoto(g.getPhoto());

                gl.setStoretid(g.getStoreid());
                gl.setStorename("门店名");
                gl.setEnterprisetid(g.getEnterpriseid());
                gl.setEnterprise("企业名");

                gl.setActivetid("");

                gl.setIstop(0);

                gl.setUpdatetime(new Date());
                gl.setEvaluate(5);

                if (!StringUtilWHY.isEmpty(gl.getSkuid())) {
                    goodsSearchDao.save(gl);
                }
            }


        }


        return null;
    }

    @Override
    public JSONObject goodsInfo(String goodsid) {
        GGoods goods = gGoodsDao.findByTid(goodsid);
        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(goods));
        List<GPhoto> photos = gPhotoDao.findByGoodsid(goodsid);
        json.put("photos", photos);
        List<GSku> gSkus = gSkuDao.findByGoodsid(goodsid);
        json.put("sku", gSkus);
        return json;
    }

    @Override
    public JSONObject saveGoods(JSONObject json) {
        JSONObject res = new JSONObject();
        // 第一步：添加商品主信息
        JSONObject main = json.getJSONObject("main");
        JSONArray photos = json.getJSONArray("photos");
        JSONArray skus = json.getJSONArray("skus");
        JSONArray details = json.getJSONArray("details");
        GGoods g = main.toJavaObject(GGoods.class);
        if (null == g.getTid()) {
            g.setTid(StringUtilWHY.getUUID());
        }
        GGoods goods = gGoodsDao.save(g);
        res.put("main", goods);
        // 第二步：添加图片列表
        String tid = goods.getTid();
        List<GPhoto> gPhotos = new ArrayList();
        for (int i = 0; i < photos.size(); i++) {
            GPhoto ph = photos.getJSONObject(i).toJavaObject(GPhoto.class);
            ph.setGoodsid(tid);
            gPhotos.add(ph);
        }
        List<GPhoto> gh = gPhotoDao.saveAll(gPhotos);
        res.put("photos", gh);
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
        List<GSku> sk = gSkuDao.saveAll(gSkus);
        res.put("skus", sk);
        // 第四步：添加详情
        List<GDetails> gDetails = new ArrayList();
        for (int i = 0; i < details.size(); i++) {
            GDetails ph = details.getJSONObject(i).toJavaObject(GDetails.class);
            ph.setGoodsid(tid);
            gDetails.add(ph);
        }
        List<GDetails> gd = gDetailsDao.saveAll(gDetails);
        res.put("details", gd);
        return res;
    }
}
