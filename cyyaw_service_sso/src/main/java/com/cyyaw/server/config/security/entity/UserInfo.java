package com.cyyaw.server.config.security.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * 用户信息
 */
@Data
@RedisHash("userinfo")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 15873011725482985L;

    @Id
    private String token;
    private String tid;
    private String note;
    private Date createtime;
    private String account;
    private String truename;
    private String phone;
    private String nickname;
    private String face;
    private String email;
    private String ip;
    private Date lastlogintime;
    private Integer status;
    private Integer type;
    private String adminid;
    private BigDecimal balance;
    private Integer integral;
    private Set<String> role;  // 角色
    private Set<String> power; // 权限
    @TimeToLive
    private Long expiration;  // 失效时间
}
