package com.cyyaw.common.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtilWHY extends StringUtils {

    private static String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        String str = UUID.randomUUID().toString();
        return str.replace("-", "");
    }
    /**
     * 生成随机数
     */
    public static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }
    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }
    /**
     * 生成订单号  2019 07 07 16 16 10
     *
     * @return
     */
    public static String createOrderNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());
        for (int i = 0; i < 6; i++) {
            format += getRandom(10);
        }
        return format;
    }

    /**
     * 生成字符串
     * @return
     */
    public static String createStr(int l, String str , String str2){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<l;i++){
            if(i!=0 && null != str2){
                sb.append(str2);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String createStrLength(String o, int l, String str){
        if(null == o) o = "";
        if(null == str) str = "0";
        for(int i= o.length();i<l ;i++){
            o= str+o;
        }
        return o;
    }
}
