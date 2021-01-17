package com.cyyaw.reptiles.thread.datahandle;

import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.reptiles.table.entity.RImg;
import com.cyyaw.reptiles.table.entity.RReptilesurl;
import com.cyyaw.reptiles.table.entity.RUrl;
import com.cyyaw.reptiles.table.entity.RWebContent;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 数据处理
 */
@Data
public class DataHandleExplain implements DataHandle{


    /**
     * 解释数据
     */
    public void explain(Document page, String url) {
        if (null != page) {
            String baseurl = StringUtilWHY.getWebIndexUrl(url, null);
            //=================
            String title = page.title();
            RReptilesurl rReptilesurl = new RReptilesurl();
            rReptilesurl.setUrl(baseurl);
            rReptilesurl.setTid(title);
            RReptilesurl r = rReptilesurlService.saveReptilesurl(rReptilesurl);
            //=================
            String baseURI = page.baseUri();
            String textContent = page.text();
            String html = page.html();
            RWebContent rw = new RWebContent();
            rw.setReptilesurlid(r.getTid());
            rw.setTitle(title);
            rw.setBaseuri(baseURI);
            rw.setContent(html);
            rw.setContenttxt(textContent);
            rw.setUrl(url);
            RWebContent rWebContent = rWebContentService.save(rw);
            String tid = rWebContent.getTid();
            //================= 爬取图片
            List<RImg> list = new ArrayList<>();
            Elements imgs = page.tagName("img").getAllElements();
            for (Element img : imgs) {
                String alt = img.attr("alt");
                String src = img.attr("src");
                RImg imgobj = new RImg();
                imgobj.setRwebcontentid(tid);
                imgobj.setUrl(StringUtilWHY.getWebIndexUrl(baseurl, src));
                imgobj.setAlt(alt);
                imgobj.setPath(src);
                list.add(imgobj);
            }
            rImgService.saveList(list);
            //=================
            Map<String, RUrl> urls = new ConcurrentHashMap<>();
            Elements targetA = page.tagName("a").getAllElements();
            for (Element a : targetA) {
                String href = a.attr("href");
                String textContent1 = a.text();
                RUrl obj = new RUrl();
                obj.setUrl(href);
                obj.setRwebcontentid(tid);
                obj.setTitle(textContent1);
                urls.put(obj.getUrl(), obj);
            }
            for (String key : urls.keySet()) {
                String webIndexUrl = StringUtilWHY.getWebIndexUrl(baseurl, key);
                if (null != webIndexUrl && !"".equals(webIndexUrl)) {
                    rabbitTemplate.convertAndSend("rabbit001", webIndexUrl);
                }

            }
        }
    }
}
