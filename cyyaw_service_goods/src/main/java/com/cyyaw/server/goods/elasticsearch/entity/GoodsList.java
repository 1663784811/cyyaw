package com.cyyaw.server.goods.elasticsearch.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Document(indexName = "goodslist")
public class GoodsList implements Serializable {
    private static final long serialVersionUID = 15768826273933758L;

    @Id
    private String tid;  // 商品表ID
    private String name; // 商品名
    private String skuid; // sku
    private String skuname; // sku
    private BigDecimal price; // 价格
    private BigDecimal lowprice; // 最低价格
    private BigDecimal highprice; // 最高价格
    private String typecode; // 品类
    private String brandcode; // 品牌
    private String photo; // 图片

    //===========  门店
    private String storetid;
    private String storename; // 门店名
    private String enterprisetid; //企业
    private String enterprise; //企业

    //===========  活动
    private String activetid; // 活动id
    private String activename; // 活动
    private Date activestart; // 开始时间
    private Date activeend; // 结束时间
    private String activephoto; // 活动图片
    private Integer activetype; // 活动类型


    //===========  排序
    private Integer istop; // 是否置顶
    private Date updatetime; // 更新日期
    private Integer evaluate; // 星级评价


}
