package com.cyyaw.server.common.util;

import com.cyyaw.common.util.StringUtilWHY;
import org.junit.Test;

public class StringUtilWHYTest {








    @Test
    public void test01(){

        String addres = "sersf>http://m.ctrip.com/webapp/you/gspoi/sight/2/14903.html?seo=0&poiId=79170&from=https%3A%2F%2Fm.ctrip.com%2Fwebapp%2Fyou%2Fgspoi%2Fsight%2F2.html%3Fseo%3D1<htwwecvf";

        String webAdd = StringUtilWHY.getWebAdd(addres);

        System.out.println("================网址::::::"+webAdd);


    }



    @Test
    public void test02(){

        String addres = "sersf>http://msee.ctr_ip.com/dsffc.comcnv/s.come4903.html?//d";

        String webAdd = StringUtilWHY.getWebIndexUrl(addres, "../dddddse.com");

        System.out.println("================网址::::::"+webAdd);


    }





}
