package com.cyyaw.server.service.impl.design.computedgoods;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sku {
    // tid
    private String tid;
    // 单价
    private BigDecimal price;
    // 数量
    private BigDecimal number;
    // 总价
    private BigDecimal totalPrice;
    //备注
    private String note;
    //商品表ID
    private String goodsid;
    //商品图片
    private String photo;
    //json商品属性
    private String attribute;
}
