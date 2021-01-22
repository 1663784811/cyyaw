package com.cyyaw.server.table.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "f_file")
@org.hibernate.annotations.Table(appliesTo = "f_file", comment = "文件表")
public class FFile implements Serializable{
    private static final long serialVersionUID = 1611242744184870L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column(name="id" ,unique = true ,nullable = false, columnDefinition = "int auto_increment COMMENT 'id'")
    private Integer id;
    @Basic
    @Column(name="createtime", columnDefinition = "datetime default 'CURRENT_TIMESTAMP' COMMENT '创建时间'")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @Basic
    @Column(name="del", columnDefinition = "int COMMENT '是否删除{0:否,1:是}'")
    private Integer del;
    @Basic
    @Column(name="name", columnDefinition = "varchar(255) COMMENT '文件名'")
    private String name;
    @Basic
    @Column(name="note", columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @Basic
    @Column(name="path", columnDefinition = "varchar(255) COMMENT '文件路径'")
    private String path;
    @Basic
    @Column(name="tid" ,unique = true ,nullable = false, columnDefinition = "varchar(32) COMMENT 'tid'")
    private String tid;
    @Basic
    @Column(name="type", columnDefinition = "int COMMENT '类型{1:文件,2:图片}'")
    private Integer type;
}
