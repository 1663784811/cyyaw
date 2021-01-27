package com.cyyaw.server.service;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;

public interface ComputedService {


    BaseResult computeGoods(JSONObject json);

}
