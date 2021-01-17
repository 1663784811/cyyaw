package com.cyyaw.server;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import com.cyyaw.server.goods.table.entity.GDetails;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GPhoto;
import com.cyyaw.server.goods.table.entity.GSku;
import com.cyyaw.server.goods.table.service.GGoodsService;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class OrderApplicationTests {


    @Autowired
    private GGoodsService ggoodsService;


    @Autowired
    private GoodsService goodsService;


    @Test
    void contextLoads() {
    }

    @Test
    public void test001() {
        String url = "https://search.jd.com/Search?keyword=内存";
        String html = requestHtml(url);
        explainHtml(html);
    }

    /**
     * 解释html
     */
    public void explainHtml(String html) {
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("gl-item");
        for (Element element : elements) {
            String names = element.getElementsByClass("p-name").get(0).text();
            String price = element.getElementsByClass("p-price").get(0).getElementsByTag("i").get(0).text();
            String img = element.getElementsByClass("p-img").get(0).getElementsByTag("img").get(0).attr("data-lazy-img");

            System.out.println(names);
            System.out.println(price);
            System.out.println(img);

            GGoods gGoods = new GGoods();
            gGoods.setName(names);
            gGoods.setPrice(new BigDecimal(price));
            gGoods.setHighprice(new BigDecimal(price));
            gGoods.setPhoto("https:" + img);

            gGoods.setCreatetime(new Date());
            gGoods.setDel(0);
            gGoods.setTid(StringUtilWHY.getUUID());
            ggoodsService.save(gGoods);
        }
    }


    /**
     * 请求数据
     */
    public String requestHtml(String url) {
        String html = null;
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        WebClientOptions options = webClient.getOptions();
        options.setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        options.setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        options.setActiveXNative(false);
        options.setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        options.setJavaScriptEnabled(false); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        webClient.waitForBackgroundJavaScript(30000);//异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束
        try {
            HtmlPage page = webClient.getPage(url);//尝试加载上面图片例子给出的网页
            html = page.asXml();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        return html;
    }


    /**
     * 添加商品
     */
    @Test
    public void test002(){
        JSONObject jsonObject = new JSONObject();
        GGoods goods = GoodsUtils.getGoods();
        jsonObject.put("main", goods);
        List<GPhoto> gPhotos = new ArrayList();
        for(int i =0;i< 5;i++){
            GPhoto gPhoto = GoodsUtils.getGPhoto();
            gPhotos.add(gPhoto);
        }
        jsonObject.put("photos", gPhotos);


        List<GSku> skus = new ArrayList();
        for(int i =0;i< 5;i++){
            skus.add(GoodsUtils.getGSku());
        }
        jsonObject.put("skus", skus);

        List<GDetails> dl = new ArrayList();
        GDetails gDetails = new GDetails();
        gDetails.setDetails("<p style='font-size:30px'>测试</p>");
        dl.add(gDetails);
        jsonObject.put("details", dl);


        goodsService.saveGoods(jsonObject);
    }

}
