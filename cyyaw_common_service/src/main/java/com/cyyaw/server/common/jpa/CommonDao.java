package com.cyyaw.server.common.jpa;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface CommonDao {

    /**
     * 通用查询
     *
     * @param json
     * @return
     */
    Map<String, Object> query(JSONObject json);

    /**
     * 通用更新
     */
    JSONArray update(String table, JSONArray data);

    /**
     * 通用删除
     *
     * @param json
     * @return
     */
    Map<String, Object> delete(JSONObject json);
}
