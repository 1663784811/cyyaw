//package com.cyyaw.reptiles.thread.core;
//
//
//import com.cyyaw.common.util.StringUtilWHY;
//import com.cyyaw.reptiles.table.entity.RImg;
//import com.cyyaw.reptiles.table.entity.RReptilesurl;
//import com.cyyaw.reptiles.table.entity.RUrl;
//import com.cyyaw.reptiles.table.entity.RWebContent;
//import com.cyyaw.reptiles.table.service.RImgService;
//import com.cyyaw.reptiles.table.service.RReptilesurlService;
//import com.cyyaw.reptiles.table.service.RUrlService;
//import com.cyyaw.reptiles.table.service.RWebContentService;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.DomElement;
//import com.gargoylesoftware.htmlunit.html.DomNodeList;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//
///**
// * 请求线程
// */
//@Component
//public class ThreadRequest {
//
//    private static final WebClient webClient = new WebClient();
//
//    @Autowired
//    RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    private RImgService rImgService;
//
//    @Autowired
//    private RReptilesurlService rReptilesurlService;
//
//    @Autowired
//    private RWebContentService rWebContentService;
//
//    @Autowired
//    private RUrlService rUrlService;
//
//    /**
//     * 多线程执行方法
//     */
//    public void run(String message) {
//        // 第一步：消息队列取消息
//        String url = StringUtilWHY.getWebAdd(message);
//        if (null != url && !"".equals(url) && rWebContentService.urlCount(url) == 0) {
//            // 第二步：请求数据
//            HtmlPage htmlPage = requestData(url);
//            // 第三步：解释数据
//            if (null != htmlPage) {
//                explain(htmlPage, url);
//            }
//        }
//    }
//
//    /**
//     * 爬取数据
//     */
//    public HtmlPage requestData(String url) {
//        HtmlPage page = null;
//        try {
//            page = webClient.getPage(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return page;
//    }
//
//    /**
//     * 解释数据
//     */
//    public void explain(HtmlPage page, String url) {
//        if (null != page) {
//            String baseurl = StringUtilWHY.getWebIndexUtl(url);
//            //=================
//            String title = page.getTitleText();
//            RReptilesurl rReptilesurl = new RReptilesurl();
//            rReptilesurl.setUrl(baseurl);
//            rReptilesurl.setTid(title);
//            RReptilesurl r = rReptilesurlService.saveReptilesurl(rReptilesurl);
//            //=================
//            String baseURI = page.getBaseURI();
//            String textContent = page.getDocumentElement().getTextContent();
//            String html = page.asXml();
//            RWebContent rw = new RWebContent();
//            rw.setReptilesurlid(r.getTid());
//            rw.setTitle(title);
//            rw.setBaseuri(baseURI);
//            rw.setContent(html);
//            rw.setContenttxt(textContent);
//            rw.setUrl(url);
//            RWebContent rWebContent = rWebContentService.save(rw);
//            String tid = rWebContent.getTid();
//            //=================
//            ArrayList<RImg> list = new ArrayList<>();
//            DomNodeList<DomElement> imgs = page.getElementsByTagName("img");
//            for (DomElement img : imgs) {
//                String alt = img.getAttribute("alt");
//                String src = img.getAttribute("src");
//                RImg imgobj = new RImg();
//                imgobj.setRwebcontentid(tid);
//                imgobj.setUrl(StringUtilWHY.getWebIndexUrl(baseurl, src));
//                imgobj.setAlt(alt);
//                imgobj.setPath(src);
//                list.add(imgobj);
//            }
//            rImgService.saveList(list);
//            //=================
//            ArrayList<RUrl> listA = new ArrayList<>();
//            DomNodeList<DomElement> targetA = page.getElementsByTagName("a");
//            for (DomElement a : targetA) {
//                String href = a.getAttribute("href");
//                String textContent1 = a.getTextContent();
//                RUrl obj = new RUrl();
//                obj.setUrl(href);
//                obj.setRwebcontentid(tid);
//                obj.setTitle(textContent1);
//                listA.add(obj);
//                rabbitTemplate.convertAndSend("rabbit001", StringUtilWHY.getWebIndexUrl(baseurl, href));
//            }
//        }
//    }
//
//
//}
