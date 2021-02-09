package com.cyyaw.server.table.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.common.util.WhyException;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.service.ComputedService;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
import com.cyyaw.server.service.impl.design.computedgoods.Sku;
import com.cyyaw.server.table.dao.ODetailsDao;
import com.cyyaw.server.table.dao.OOrderDao;
import com.cyyaw.server.table.entity.ODetails;
import com.cyyaw.server.table.entity.OOrder;
import com.cyyaw.server.table.service.OOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class OOrderServiceImpl extends BaseService<OOrder, Integer> implements OOrderService {

    @Autowired
    private OOrderDao oOrderDao;


    @Autowired
    private ComputedService computedService;

    @Autowired
    private ODetailsDao oDetailsDao;


    @Override
    public BaseDao getBaseDao() {
        return oOrderDao;
    }


    @Override
    public BaseResult findByUserid(String uid, String search, Integer page, Integer size) {
        // 查订单
        OOrder order = new OOrder();
        order.setUserid(uid);
        Example<OOrder> of = Example.of(order);
        Page<OOrder> all = oOrderDao.findAll(of, PageRequest.of(page - 1, size));
        List<OOrder> list = all.getContent();
        List<String> orderNo = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            OOrder oOrder = list.get(i);
            orderNo.add(oOrder.getTid());
        }
        List<ODetails> oDetailsList = oDetailsDao.findByOrderids(orderNo);
        // 查订单详情
        JSONArray arr = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject json = JSONObject.parseObject(JSONObject.toJSON(list.get(i)).toString());
            String tid = json.getString("tid");
            List<ODetails> details = new ArrayList<>();
            for (int j = 0; j < oDetailsList.size(); j++) {
                ODetails oDetails = oDetailsList.get(j);
                String orderid = oDetails.getOrderid();
                if (null != orderid && orderid.equals(tid)) {
                    details.add(oDetails);
                }
            }
            json.put("odetails", details);
            arr.add(json);
        }

        long total = all.getTotalElements();
        return BaseResult.ok(arr, new BaseResult.Result(page, size, total));
    }

    @Override
    public BaseResult findOrderList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<OOrder> all = oOrderDao.findAll(pageable);
        List<OOrder> content = all.getContent();
        long total = all.getTotalElements();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

    @Override
    public ComputedRest createOrder(JSONObject json) {
        String userid = json.getString("userid");
        String username = json.getString("username");
        String enterpriseid = json.getString("enterpriseid");
        String enterprisename = json.getString("enterprisename");
        String storeid = json.getString("storeid");
        String storename = json.getString("storename");
        String addressid = json.getString("addressid");
        String addressdetail = json.getString("addressdetail");
        String phone = json.getString("phone");
        String description = json.getString("description");

        if (StringUtilWHY.isEmpty(userid) ||
                StringUtilWHY.isEmpty(enterpriseid) ||
                StringUtilWHY.isEmpty(storeid) ||
                StringUtilWHY.isEmpty(phone)) {
            throw new WhyException("订单信息不全");
        }

        ComputedRest computedRest = json.toJavaObject(ComputedRest.class);
        // 加锁

        // 计算价格
        ComputedRest computed = computedService.computeGoods(computedRest);
        BigDecimal computedPrice = computed.getComputedPrice();
        BigDecimal totalPrice = computed.getTotalPrice();
        BigDecimal activePrice = computed.getActivePrice();
        BigDecimal couponPrice = computed.getCouponPrice();
        BigDecimal total = computed.getTotal();
        List<Sku> skuList = computed.getSkuList();
        // 减少库存

        // 生成订单号
        String orderid = StringUtilWHY.getUUID();
        OOrder oOrder = new OOrder();
        oOrder.setTid(orderid);
        oOrder.setUserid(userid);
        oOrder.setUsername(username);
        oOrder.setEnterpriseid(enterpriseid);
        oOrder.setEnterprisename(enterprisename);
        oOrder.setStoreid(storeid);
        oOrder.setStorename(storename);
        oOrder.setOrderno(StringUtilWHY.createOrderNum());
        oOrder.setType(0);
        oOrder.setStatus("创建订单");
        oOrder.setAddressid(addressid);
        oOrder.setAddressdetail(addressdetail);
        oOrder.setPhone(phone);
        oOrder.setDescription(description);
        oOrder.setNumber(total);
        oOrder.setAmount(totalPrice);
        oOrder.setExpressprice(new BigDecimal(0));
        oOrder.setPayableamount(computedPrice);
        OOrder order = oOrderDao.save(oOrder);
        // 生成订单详情
        List<ODetails> oDetailsList = new ArrayList<>();
        for (int i = 0; i < skuList.size(); i++) {
            Sku sku = skuList.get(i);
            ODetails oDetails = new ODetails();
            oDetails.setTid(StringUtilWHY.getUUID());
            oDetails.setOrderid(orderid);
            oDetails.setGoodsid(sku.getGoodsid());
            oDetails.setSkuid(sku.getTid());
            oDetails.setType(0);
            oDetails.setName(sku.getName());
            oDetails.setPhoto(sku.getPhoto());
            oDetails.setPrice(sku.getTotalPrice());
            oDetails.setLastprice(sku.getTotalPrice());
            oDetails.setNumber(sku.getNumber());
            ODetails details = oDetailsDao.save(oDetails);
            oDetailsList.add(details);
        }
        computed.setOrder(order);
        computed.setDetailsList(oDetailsList);
        return computed;
    }
}

