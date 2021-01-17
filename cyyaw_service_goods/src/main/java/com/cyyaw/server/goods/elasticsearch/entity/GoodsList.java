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
    private Integer id;
    private String tid;
    private Date updatetime;
    private String name;
    private BigDecimal price;
    private BigDecimal lowprice;
    private BigDecimal highprice;
    private String typecode;
    private String brandcode;
    private String photo;
    private Integer istop;
    private Integer evaluate;
}
