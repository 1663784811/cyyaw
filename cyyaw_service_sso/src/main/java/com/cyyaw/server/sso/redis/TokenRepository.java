package com.cyyaw.server.sso.redis;

import com.cyyaw.server.config.security.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;



public interface TokenRepository  extends CrudRepository<UserInfo, String> {






}
