package com.cyyaw.server.table.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "e_admin_power")
@org.hibernate.annotations.Table(appliesTo = "e_admin_power", comment = "管理员_权限表")
public class EAdminPower implements Serializable {
    private static final long serialVersionUID = 1568782627140356L;
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
    @Column(name = "adminid", columnDefinition = "varchar(32) COMMENT '管理员表ID'")
    private String adminid;
    @Basic
    @Column(name = "adminroleid", columnDefinition = "varchar(32) COMMENT '管理员角色表ID'")
    private String adminroleid;

    @Basic
    @Column(name = "powerid", columnDefinition = "varchar(32) COMMENT '权限表ID'")
    private String powerid;

}
