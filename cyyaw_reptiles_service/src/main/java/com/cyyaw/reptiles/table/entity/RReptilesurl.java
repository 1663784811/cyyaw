package com.cyyaw.reptiles.table.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@DynamicInsert
@Table(name = "r_reptilesurl")
@org.hibernate.annotations.Table(appliesTo = "r_reptilesurl", comment = "爬虫地址")
public class RReptilesurl implements Serializable {
    private static final long serialVersionUID = 15373933758L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "int auto_increment COMMENT 'id'")
    private Integer id;
    @Basic
    @Column(name = "tid", unique = true, columnDefinition = "varchar(32) not null COMMENT 'tid'")
    private String tid;
    @Basic
    @Column(name = "del", length = 10, columnDefinition = "int default '0' COMMENT '是否删除{0:否,1:是}'")
    private Integer del;
    @Basic
    @Column(name = "note", columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @Basic
    @Column(name = "createtime", length = 19, columnDefinition = "datetime default now() COMMENT '创建时间'")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @Basic
    @Column(name = "url", columnDefinition = "text COMMENT '爬取的地址'")
    private String url;

    @Basic
    @Column(name = "title", columnDefinition = "varchar(255) COMMENT '爬取的标题'")
    private String title;

    @Basic
    @Column(name = "type", length = 10, columnDefinition = "int COMMENT '网址类型{0:默认}'")
    private Integer type;

    @Basic
    @Column(name = "requesttype", length = 10, columnDefinition = "int COMMENT '请求类型{0:GET,1:POST}'")
    private Integer requesttype;

}
