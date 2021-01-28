package com.cyyaw.server.service.impl.design.computedgoods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 计算结果
 */
@Data
public class ComputedRest {
    // 最后结算价格
    private BigDecimal computedPrice;
    // 总价
    private BigDecimal totalPrice;
    // 优惠券优惠
    private BigDecimal couponPrice;
    // 活动优惠
    private BigDecimal activePrice;
    //商品总数
    private BigDecimal total;
    // 商品列表
    private List<Sku> skuList;
}
