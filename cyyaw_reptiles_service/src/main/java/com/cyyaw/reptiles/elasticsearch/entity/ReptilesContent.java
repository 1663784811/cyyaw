package com.cyyaw.reptiles.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@Document(indexName = "reptilescontent")
public class ReptilesContent implements Serializable {
    private static final long serialVersionUID = 1553933758L;
    @Id
    private String tid;
    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date createtime;
    private String reptilesurlid;
    private String url;
    private String baseuri;
    private String title;
    private Integer requesttype;
    private String contenttxt;
}
