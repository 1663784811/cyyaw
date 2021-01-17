package com.cyyaw.reptiles.thread.reptile;


import java.util.Map;

/**
 * 爬取数据
 */
public interface ReptilesData {


    /**
     * 爬取数据
     * @param url 地址
     * @param param 参数
     * @return html 代码
     */
    String reptiles(String url, Map<String,Object> param);

}
