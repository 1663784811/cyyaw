package com.cyyaw.server.table.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@DynamicInsert
@Data
@Entity
@Table(name = "e_statistics")
@org.hibernate.annotations.Table(appliesTo = "e_statistics", comment = "统计表")
public class EStatistics implements Serializable {
    private static final long serialVersionUID = 1568782627332870L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "int auto_increment COMMENT 'id'")
    private Integer id;
    @Basic
    @Column(name = "tid", unique = true, length = 32, columnDefinition = "varchar(32) not null COMMENT 'tid'")
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
    @Column(name = "adduser", length = 10, columnDefinition = "int COMMENT '新增用户'")
    private Integer adduser;

    @Basic
    @Column(name = "man", length = 10, columnDefinition = "int COMMENT '男生'")
    private Integer man;
    @Basic
    @Column(name = "women", length = 10, columnDefinition = "int COMMENT '女生'")
    private Integer women;
    @Basic
    @Column(name = "[unknown]", length = 10, columnDefinition = "int COMMENT '未知'")
    private Integer unknown;
    @Basic
    @Column(name = "userall", length = 10, columnDefinition = "int COMMENT '所有用户'")
    private Integer userall;
    @Basic
    @Column(name = "visit", length = 10, columnDefinition = "int COMMENT '今天访问量'")
    private Integer visit;
    @Basic
    @Column(name = "visitall", length = 10, columnDefinition = "int COMMENT '总访问量'")
    private Integer visitall;
    @Basic
    @Column(name = "weixinuser", length = 10, columnDefinition = "int COMMENT '微信用户'")
    private Integer weixinuser;

}
