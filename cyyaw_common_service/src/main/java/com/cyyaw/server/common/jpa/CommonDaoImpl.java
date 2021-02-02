package com.cyyaw.server.common.jpa;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.util.DateUtils;
import com.cyyaw.common.util.SqlUtils;
import com.cyyaw.common.util.StringUtilWHY;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

@Slf4j
@Repository
public class CommonDaoImpl implements CommonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Map<String, Object> query(JSONObject json) {
        HashMap<String, Object> map = new HashMap<>();
        //第一步：查询  sql 字符串
        Integer page = json.getInteger("page");
        Integer size = json.getInteger("size");
        page = page == null ? 1 : page;
        size = size == null ? 30 : size;
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from c_sql c where c.tid = ?", json.getString("_code"));
        if (sqlRowSet.next()) {
            String countsql = sqlRowSet.getString("countsql");
            String sqlcontent = sqlRowSet.getString("sqlcontent");
            // 第二步：替换字符串
            String querySql = SqlUtils.explainSql(sqlcontent, json) + " limit " + ((page - 1) * size + "," + size);
            String countSql = SqlUtils.explainSql(countsql, json);
            log.info("============================================");
            log.info("统计sql语句: {} ", countSql);
            log.info("执行sql语句: {} ", querySql);
            log.info("============================================");
            //第三步：执行sql
            Integer total = jdbcTemplate.queryForObject(countSql, Integer.class);
            List<Map<String, Object>> data = jdbcTemplate.queryForList(querySql);
            if (null != data && data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    Map<String, Object> mapObj = data.get(i);
                    for (String key : mapObj.keySet()) {
                        Object dateTime = mapObj.get(key);
                        if (dateTime instanceof Timestamp) {
                            mapObj.put(key, DateUtils.getStringDate((Timestamp) dateTime));
                        }
                    }
                    data.set(i, mapObj);
                }
            }
            //第四步：返回结果列表
            map.put("code", 0);
            map.put("data", data);
            map.put("msg", "ok");
            map.put("total", total);
            map.put("page", page);
            map.put("size", size);
            return map;
        } else {
            map.put("code", -1);
            map.put("msg", "找不到可用条件");
        }
        return map;
    }

    @Override
    public JSONArray update(String database, String table, JSONArray data) {
        // 第一步: 查询表结构
        JSONArray reArr = new JSONArray();
        if (null != data && data.size() > 0) {
            JSONArray page = tableInfo(table, database);
            JSONArray addArr = new JSONArray();
            JSONArray updateArr = new JSONArray();
            String pk = null;
            //============================判断数据库是否有数据
            for (int i = 0; i < page.size(); i++) {
                JSONObject js = page.getJSONObject(i);
                String columnName = js.getString("column_name");
                String columnKey = js.getString("column_key");
                if (columnKey.equals("PRI")) {
                    pk = columnName;
                    for (int j = 0; j < data.size(); j++) {
                        JSONObject mm = data.getJSONObject(j);
                        String id = mm.getString(columnName);
                        if (StringUtilWHY.isEmpty(id)) {
                            addArr.add(mm);
                        } else {
                            updateArr.add(mm);
                        }
                    }
                    break;
                }
            }
            //=======================   添加数据
            if (addArr.size() > 0) {
                addData(table, addArr, page);
            }
            //=======================   修改数据
            if (updateArr.size() > 0) {
                updateData(table, pk, updateArr, page);
            }
            reArr.addAll(addArr);
            reArr.addAll(updateArr);
        }
        return reArr;
    }

    @Override
    public Map<String, Object> delete(String database, JSONObject json) {
        // 第一步: 查询表结构
        String table = json.getString("table");
        JSONArray data = json.getJSONArray("data");
        JSONArray reArr = new JSONArray();
        String pk = null;
        if (null != data && data.size() > 0) {
            JSONArray page = tableInfo(table, database);
            JSONArray delArr = new JSONArray();
            // 判断数据库是否有数据
            for (int i = 0; i < page.size(); i++) {
                JSONObject js = page.getJSONObject(i);
                String columnName = js.getString("column_name");
                String columnKey = js.getString("column_key");
                if (columnKey.equals("PRI")) {
                    pk = columnName;
                    for (int j = 0; j < data.size(); j++) {
                        JSONObject mm = data.getJSONObject(j);
                        String id = mm.getString(columnName);
                        if (!StringUtilWHY.isEmpty(id)) {
                            delArr.add(mm);
                        }
                    }
                    break;
                }
            }
            // 删除
            if (delArr.size() > 0) {
                List slist = new ArrayList<>();
                for (int i = 0; i < delArr.size(); i++) {
                    slist.add(delArr.getJSONObject(i).getString(pk));
                }
                String sql = "delete FROM " + table + " where " + pk + " in (" + StringUtilWHY.createStr(slist.size(), "?", ",") + ")";
                jdbcTemplate.update(sql, slist.toArray());
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "ok");
        map.put("data", reArr);
        return map;
    }


    private JSONArray tableInfo(String table, String databse) {
        StringBuffer sb = new StringBuffer("select ");
        sb.append(" table_name as table_name");
        sb.append(" ,column_name as column_name");
        sb.append(" ,data_type as data_type");
        sb.append(" ,column_key as column_key");
        sb.append(" from information_schema.columns where table_name= ? and table_schema = ?");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sb.toString(), table, databse);
        return JSONArray.parseArray(JSON.toJSON(maps).toString());
    }

    /**
     * 更新数据操作
     */
    private void updateData(String table, String pk, JSONArray updateArr, JSONArray page) {
        if (!StringUtilWHY.isEmpty(pk)) {
            for (int i = 0; i < updateArr.size(); i++) {
                JSONObject obj = updateArr.getJSONObject(i);

                String pkvalue = null;
                StringBuffer sb = new StringBuffer();
                StringBuffer set = new StringBuffer();
                String newpid = "";
                Integer treeIndex = -1;
                List<String> list = new ArrayList<>();
                sb.append("update " + table + " set ");
                boolean isTree = isTree(page);
                // =============================================================  设置数据
                for (int j = 0; j < page.size(); j++) {
                    JSONObject js = page.getJSONObject(j);
                    String name = js.getString("column_name");
                    String columnKey = js.getString("column_key");
                    String cn = obj.getString(name);  // 值
                    if (null != cn) {
                        if (columnKey.equals("PRI")) {
                            pkvalue = cn;
                        } else if (isTree && !"treecode".equals(name)) {
                            if (set.length() > 0) {
                                set.append(",`" + name + "` = ? ");
                            } else {
                                set.append("`" + name + "` = ? ");
                            }
                            list.add(cn);
                        }
                        if (isTree && "pid".equals(name)) {
                            newpid = cn;
                        }
                    }
                }
                // =============================================================  修改


                if (null != pkvalue) {
                    String oldtreecode = null;           // 原数据库pid
                    String newtreecode = null;      // 修改后数据库pid
                    if (isTree) { // 处理树
                        // 第一步：================  查询原数据
                        String sql = "select * from " + table + " where `" + pk + "` = ?";
                        List<Map<String, Object>> oldData = jdbcTemplate.queryForList(sql, pkvalue);
                        Map<String, Object> old = oldData.get(0);
                        Object pid = old.get("pid");
                        String oldpid = ""; // 原数据库pid
                        if (pid != null) {
                            oldpid = pid.toString();
                        }
                        Object trcode = old.get("treecode");
                        if (null != trcode) {
                            oldtreecode = trcode.toString();
                        } else {
                            oldtreecode = "";
                        }
                        // 判断是否修改了父节点
                        if (!newpid.equals(oldpid)) {
                            // 计算treecode 的值
                            String pTreeCode = "";
                            if (!StringUtilWHY.isEmpty(newpid)) {
                                List<Map<String, Object>> parentList = jdbcTemplate.queryForList("select treecode from " + table + " where tid = ? ", newpid);
                                if (null != parentList && parentList.size() > 0) {
                                    Object treecode = parentList.get(i).get("treecode");
                                    if (null != treecode) {
                                        pTreeCode = treecode.toString();
                                    }

                                }
                            }
                            //========= maxPid
                            String s = null;
                            List<Map<String, Object>> maxPid = jdbcTemplate.queryForList(
                                    "select max(substring(m.treecode,-3)) as maxcode from " + table + " m where ifnull(?,'') = ifnull(m.pid,'')",
                                    newpid
                            );
                            if (null != maxPid && maxPid.size() > 0) {
                                Object maxcode = maxPid.get(0).get("maxcode");
                                if (null != maxcode) {
                                    s = maxcode.toString();
                                }
                            }
                            int trint = 1;
                            if (!StringUtilWHY.isEmpty(s)) {
                                trint = Integer.parseInt(s) + 1;
                            }
                            String tr = StringUtilWHY.createStrLength(trint + "", 3, "0");
                            if (set.length() > 0) {
                                set.append(",`treecode` = ? ");
                            } else {
                                set.append("`treecode` = ? ");
                            }
                            newtreecode = pTreeCode + tr;
                            list.add(newtreecode);
                        }
                    }
                    //更新数据
                    sb.append(set);
                    sb.append(" where " + pk + " = ?");
                    list.add(pkvalue);
                    jdbcTemplate.update(sb.toString(), list.toArray());
                    //更新子节点
                    if (null != oldtreecode && !oldtreecode.equals(newtreecode)) {
                        updateNextNode(table, pk, oldtreecode, newtreecode);
                    }
                }
            }
        }
    }

    /**
     * 添加数据操作
     */
    private void addData(String table, JSONArray addArr, JSONArray page) {
        for (int i = 0; i < addArr.size(); i++) {
            List<String> list = new ArrayList<>();
            StringBuffer datakey = new StringBuffer();
            StringBuffer set = new StringBuffer();
            JSONObject obj = addArr.getJSONObject(i);
            boolean isTree = isTree(page);
            for (int j = 0; j < page.size(); j++) {
                JSONObject js = page.getJSONObject(j);
                String name = js.getString("column_name");
                String cn = obj.getString(name);   // 数据
                //================== 初始化数据
                if (StringUtilWHY.isEmpty(cn) && name.equals("tid")) {
                    cn = StringUtilWHY.getUUID();
                }
                if (null != cn || (isTree && "treecode".equals(name))) {
                    //==================  添加字段
                    if (datakey.length() > 0) {
                        datakey.append(",`" + name + "`");
                        set.append(",?");
                    } else {
                        datakey.append("`" + name + "`");
                        set.append("?");
                    }
                    if (isTree && "treecode".equals(name)) {
                        // 计算treecode 的值
                        String pid = obj.getString("pid");
                        if (null == pid) pid = "";
                        String pTreeCode = "";
                        if (!StringUtilWHY.isEmpty(pid)) {
                            List<Map<String, Object>> parentList = jdbcTemplate.queryForList("select treecode from " + table + " where tid = ? ", pid);
                            if (null != parentList && parentList.size() > 0) {
                                Object treecode = parentList.get(i).get("treecode");
                                if (null != treecode) {
                                    pTreeCode = treecode.toString();
                                }

                            }
                        }
                        //========= maxPid
                        String s = null;
                        List<Map<String, Object>> maxPid = jdbcTemplate.queryForList(
                                "select max(substring(m.treecode,-3)) as maxcode from " + table + " m where ifnull(?,'') = ifnull(m.pid,'')",
                                pid
                        );
                        if (null != maxPid && maxPid.size() > 0) {
                            Object maxcode = maxPid.get(0).get("maxcode");
                            if (null != maxcode) {
                                s = maxcode.toString();
                            }
                        }
                        int trint = 1;
                        if (!StringUtilWHY.isEmpty(s)) {
                            trint = Integer.parseInt(s) + 1;
                        }
                        String tr = StringUtilWHY.createStrLength(trint + "", 3, "0");
                        list.add(pTreeCode + tr);
                    } else {
                        list.add(cn);   // 数据
                    }
                }
            }
            String sqlinsert = "insert into " + table + "(" + datakey.toString() + ") values (" + set.toString() + ")";
            jdbcTemplate.update(sqlinsert, list.toArray());
        }
    }

    private boolean isTree(JSONArray page) {
        int tree = 0;
        for (int i = 0; i < page.size(); i++) {
            JSONObject js = page.getJSONObject(i);
            String name = js.getString("column_name");
            if ("pid".equals(name) || "tid".equals(name) || "treecode".equals(name)) {
                tree++;
            }
        }
        return tree == 3;
    }

    /**
     * 更新子节点
     */
    private void updateNextNode(String table, String pk, String oldTreecode, String newtreecode) {
        List<Map<String, Object>> nextNode = jdbcTemplate.queryForList(
                "select * from " + table + " where length( treecode ) >? and treecode like concat(?,'%')"
                , oldTreecode.length()
                , oldTreecode
        );
        if (null != nextNode && nextNode.size() > 0) {
            for (int i = 0; i < nextNode.size(); i++) {
                JSONObject json = new JSONObject(nextNode.get(i));
                String treecode = json.getString("treecode");
                String pkval = json.getString(pk);
                String replace = treecode.replace(oldTreecode, newtreecode);
                String sql = "update `" + table + "` set treecode = ? where `"+pk+"`= ?";
                jdbcTemplate.update(sql, replace, pkval);
            }
        }
    }

}
