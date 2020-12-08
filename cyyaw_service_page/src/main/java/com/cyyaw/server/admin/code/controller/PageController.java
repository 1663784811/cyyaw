package com.cyyaw.server.admin.code.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.ResponseUtils;
import com.cyyaw.server.admin.code.database.TypeTools;
import com.cyyaw.server.admin.code.service.PageService;
import com.cyyaw.server.admin.code.tools.database.DataBase;
import com.cyyaw.server.admin.code.tools.entity.java.JavaColumn;
import com.cyyaw.server.admin.code.tools.entity.java.JavaData;
import com.cyyaw.server.admin.code.tools.entity.vue.VueJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/config/page")
@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pwd;

    /**
     * 获取页面设置
     */
    @RequestMapping("/pageConfig")
    public BaseResult pageConfig(String pageid) {
        JSONObject pageConfig = pageService.pageConfig(pageid);
        return BaseResult.ok(pageConfig);
    }

    /**
     * 读取数据表
     */
    @PostMapping("/readDataBaseTable")
    public void readDataBaseTable(HttpServletResponse response) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase(driver, url, user, pwd);
        List<JavaData> tableList = dataBase.getTableList(null);
        JSONArray arr = new JSONArray();
        for (int i = 0; i < tableList.size(); i++) {
            JavaData javaData = tableList.get(i);
            JSONObject json = new JSONObject();
            json.put("database", javaData.getDatabase());
            json.put("tablenote", javaData.getTablenote());
            json.put("table", javaData.getTable());
            JSONArray fields = new JSONArray();
            List<JavaColumn> javacolumns = javaData.getJavacolumns();
            if(null != javacolumns){
                for(int j=0;j<javacolumns.size();j++){
                    JavaColumn java = javacolumns.get(j);
                    VueJson vueJson = TypeTools.javaColumn2VueJson(java);
                    JSONObject js = new JSONObject();
                    js.put("title",vueJson.getTitle());
                    js.put("key",vueJson.getKey());
                    js.put("length",vueJson.getLength());
                    js.put("isrequire",vueJson.getIsrequire()?1:0);
                    js.put("javatype",vueJson.getJavatype());
                    js.put("iswhere",vueJson.getIswhere()?1:0);
                    js.put("javawhere",vueJson.getJavawhere());
                    js.put("isshowcolumn",vueJson.getIsshowcolumn()?1:0);
                    js.put("format",vueJson.getFormat());
                    js.put("message",vueJson.getMessage());
                    js.put("controltype",vueJson.getControltype());
                    js.put("selectarr", vueJson.getFilters());

                    fields.add(js);
                }
            }
            json.put("fields", fields);
            arr.add(json);
        }
        ResponseUtils.responseJsonFilter(response, arr);
    }

}


