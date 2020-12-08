package com.cyyaw.server.admin.code.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.admin.code.database.TypeTools;
import com.cyyaw.server.admin.code.service.PageService;
import com.cyyaw.server.admin.table.table.dao.PFieldDao;
import com.cyyaw.server.admin.table.table.dao.PPageComponentsDao;
import com.cyyaw.server.admin.table.table.dao.PPageDao;
import com.cyyaw.server.admin.table.table.entity.PField;
import com.cyyaw.server.admin.table.table.entity.PPage;
import com.cyyaw.server.admin.table.table.entity.PPageComponents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PPageDao pPageDao;

    @Autowired
    private PPageComponentsDao pPageComponentsDao;

    @Autowired
    private PFieldDao pFieldDao;


    @Override
    public JSONObject pageConfig(String tid) {
        // 第一步：查找页面
        PPage page = pPageDao.findByTid(tid);
        JSONObject pageObj = JSONObject.parseObject(JSONObject.toJSONString(page));
        if (null != page) {
            // 第二步：查找组件
            List<PPageComponents> components = pPageComponentsDao.findByPageid(pageObj.getString("tid"));
            JSONArray componentsArr = JSONArray.parseArray(JSONArray.toJSONString(components));
            if (null != components && components.size() > 0) {
                List<String> ctidArr = new ArrayList<>();
                for (int i = 0; i < componentsArr.size(); i++) {
                    JSONObject json = componentsArr.getJSONObject(i);
                    ctidArr.add(json.getString("tid"));
                }
                List<PField> pFieldList = pFieldDao.findByComponentsId(ctidArr);
                JSONArray fieldArr = JSONArray.parseArray(JSONArray.toJSONString(pFieldList));
                JSONObject componentsObj = new JSONObject();
                for (int i = 0; i < componentsArr.size(); i++) {
                    JSONObject json = componentsArr.getJSONObject(i);
                    String ctid = json.getString("tid");
                    JSONArray arr = new JSONArray();
                    for (int j = 0; j < fieldArr.size(); j++) {
                        JSONObject js = fieldArr.getJSONObject(j);
                        String componentsid = js.getString("componentsid");
                        if (ctid.equals(componentsid)) {
                            String controldata = js.getString("controldata");
                            if(!StringUtilWHY.isEmpty(controldata)){
                                js.put("selectarr", TypeTools.getLabelAndValue(controldata));
                            }
                            arr.add(js);
                        }
                    }
                    json.put("fieldArr", arr);
                    componentsObj.put(ctid, json);
                }
                pageObj.put("components", componentsObj);
            }
        }
        return pageObj;
    }
}
