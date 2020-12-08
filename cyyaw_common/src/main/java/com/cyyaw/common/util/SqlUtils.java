package com.cyyaw.common.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释sql工具类
 *
 * <prl>
 * <p>
 * select * from sys_user s where s.id = '123' and s.name = '张三'
 * {=a select * from sys_user s where [s.id] and [%s.name] {=b and [s.age]} }
 * <p>
 * {=a }  块判断
 * <p>
 * []  --->   =
 * [@]  --->   in
 * [!@] ---->  not in
 * [%]  ---->  like
 * [L%]  ---->  like
 * [R%]  ---->  like
 * [!%]  ---->  not like
 * [:=]  ---->  别名  [cc:=sss]
 * [!!>=] ---->  大于等于
 * [!!<=] ---->  小于等于
 *
 * </prl>
 */
public class SqlUtils {

    /**
     * 解释sql
     */
    public static String explainSql(String sql, JSONObject json) {
        Map<String, String> map = explainSquare(sql, json);
        for (String key : map.keySet()) {
            sql = sql.replace(key, map.get(key));
        }
        return sql;
    }

    /**
     * 解释内容{}括号
     */
    private static String explainCurly(String sql, String strArr[]) {
        int index = sql.indexOf("{=");
        if (index != -1) {
            for (int i = index; i < sql.length(); i++) {

            }
            return null;
        } else {
            return sql;
        }
    }

    /**
     * 解释 [] 括号内的内容
     *
     * @param sql
     * @return
     */
    private static Map<String, String> explainSquare(String sql, JSONObject json) {
        Map<String, String> map = new HashMap<>();
        int start = 0;
        int startFlag = 0;
        int endFlag = 0;
        for (int i = 0; i < sql.length(); i++) {
            if (sql.charAt(i) == '[') {
                startFlag++;
                if (startFlag == endFlag + 1) {
                    start = i;
                }
            } else if (sql.charAt(i) == ']') {
                endFlag++;
                if (endFlag == startFlag) {
                    map.put(sql.substring(start, i + 1), explainWhere(sql.substring(start + 1, i), json));
                }
            }
        }
        return map;
    }


    /**
     * []     ---->   =
     * [@]    ---->   in
     * [!@]   ---->  not in
     * [%]    ---->  like
     * [L%]   ---->  like
     * [R%]   ---->  like
     * [!%]   ---->  not like
     * [>=] ---->  大于等于
     * [<=] ---->  小于等于
     * [>] ---->  大于
     * [<] ---->  小于
     * [:=]   ---->  别名  [cc:=sss]
     * [*]   ----> null
     * [!*]   ----> 非null
     */
    /**
     * 解释 where 条件的内容
     *
     * @param str
     * @param json
     * @return
     */
    private static String explainWhere(String str, JSONObject json) {
        int index = 0;
        int keyIndex = 0;
        String key = null;
        if ((keyIndex = str.indexOf(":=")) > 0) {
            key = str.substring(0, keyIndex);
        }

        if ((index = str.indexOf("!@")) != -1) {
            String keyN = str.substring(index + 2);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " not in (" + addstr(value, ",", "'") + ")";
            }
        } else if ((index = str.indexOf("@")) != -1) {
            String keyN = str.substring(index + 1);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " in (" + addstr(value, ",", "'") + ")";
            }
        } else if ((index = str.indexOf("!%")) != -1) {
            String keyN = str.substring(index + 2);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " not like '" + value + "'";
            }
        } else if ((index = str.indexOf("L%")) != -1) {
            String keyN = str.substring(index + 2);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " like '%" + value + "'";
            }
        } else if ((index = str.indexOf("R%")) != -1) {
            String keyN = str.substring(index + 2);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " like '" + value + "%'";
            }
        } else if ((index = str.indexOf("%")) != -1) {
            String keyN = str.substring(index + 1);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " like '%" + value + "%'";
            }
        } else if ((index = str.indexOf(">=")) != -1) {
            String keyN = str.substring(index + 2);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " >= '" + value + "'";
            }
        } else if ((index = str.indexOf("<=")) != -1) {
            String keyN = str.substring(index + 2);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " <= '" + value + "'";
            }
        } else if ((index = str.indexOf(">")) != -1) {
            String keyN = str.substring(index + 1);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " > '" + value + "'";
            }
        } else if ((index = str.indexOf("<")) != -1) {
            String keyN = str.substring(index + 1);
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " < '" + value + "'";
            }
        }else{
            String keyN = str;
            String value = null;
            if (null != key) {
                value = json.getString(key);
            } else {
                String[] s = keyN.split("\\.");
                value = json.getString(s[s.length-1]);
            }
            if (!StringUtilWHY.isEmpty(value)) {
                return keyN + " = '" + value + "'";
            }
        }
        return "1=1";
    }

    /**
     * 添加字符串
     *
     * @param str
     * @param rstr
     * @param addstr
     * @return
     */
    private static String addstr(final String str, final String rstr, final String addstr) {
        if (!StringUtilWHY.isEmpty(str)) {
            String[] split = str.split(rstr);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < split.length; i++) {
                if (i == 0 && split.length > 1) {
                    sb.append(addstr + split[i] + addstr);
                } else {
                    sb.append("," + addstr + split[i] + addstr);
                }

            }
            return sb.toString();
        } else {
            return null;
        }
    }
}
