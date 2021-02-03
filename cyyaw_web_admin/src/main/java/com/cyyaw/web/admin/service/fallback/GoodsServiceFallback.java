package com.cyyaw.web.admin.service.fallback;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.GoodsService;
import org.springframework.stereotype.Component;


@Component
public class GoodsServiceFallback implements GoodsService {
    @Override
    public BaseResult search(Integer page, Integer size, String search) {
        return null;
    }

    @Override
    public BaseResult goodsInfo(String goodsid) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findDetailsByGoodsid(String goodsid) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findDepositoryList(Integer page, Integer size) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult saveDepository(JSONObject json) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findGoods(Integer page, Integer size, String search) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findShopGoods(Integer page, Integer size, String search) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findPageBrand(Integer page, Integer size, String search) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult findPageType(Integer page, Integer size, String search) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult saveType(JSONObject json) {
        return BaseResult.fail();
    }

    @Override
    public BaseResult saveBrand(JSONObject json) {
        return BaseResult.fail();
    }
}
