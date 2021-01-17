package com.cyyaw.reptiles.thread.reptile;

import com.cyyaw.common.util.StringUtilWHY;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;

public class ReptilesDataThread implements ReptilesData {

    /**
     * 多线程执行方法
     *
     * @param url   地址
     * @param param 参数
     * @return
     */
    @Override
    public String reptiles(String url, Map<String, Object> param) {
        String urlstr = StringUtilWHY.getWebAdd(url);
        String data = null;
        if (!StringUtilWHY.isEmpty(urlstr)) {
            try {
                data = Jsoup.connect(url).get().html();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
