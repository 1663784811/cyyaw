package com.cyyaw.web.admin.service.fallback;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.MyOrderService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AdminServiceFallback implements MyOrderService {


    @Override
    public BaseResult orderList(String userid, String search, Integer page, Integer size) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findOrderList(Integer page, Integer size) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult computeGoods(JSONObject json) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult createOrder(JSONObject json) {
        return BaseResult.fail();
    }
}
