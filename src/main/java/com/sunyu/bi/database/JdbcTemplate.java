package com.sunyu.bi.database;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunyu.bi.model.DataSource;
import com.sunyu.bi.util.DbUtil;
import com.sunyu.bi.vo.CfgContent;
import com.sunyu.bi.vo.ConfigContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {
    /**
     *
     */
    private static Logger logger = LoggerFactory.getLogger(DbUtil.class);

    /**
     *  从数据库中获取查询信息
     * @param dbInfo
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String, Object>> queryList(DataSource dbInfo, String sql, Map<String,Object> params) {
        List<Map<String,Object>> lists = new ArrayList<>();
        logger.debug("bi-sql:{}",sql);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = DbUtil.getConnection(dbInfo.getDriver(),dbInfo.getLinkUrl(),dbInfo.getLinkName(),dbInfo.getLinkPwd());
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            lists = getListFromRs(rs);
        }catch (SQLException e){
            logger.error("查询数据失败：{}",e);
        }finally {
            DbUtil.close(conn,pstmt,rs);
        }
        return lists;
    }

    private static List<Map<String, Object>> getListFromRs(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();//得到结果集列的属性
        int columns = md.getColumnCount();//得到记录有多少列
        int i;
        List<Map<String, Object>> list = new ArrayList<>();
        while(rs.next()){
            Map<String, Object> map = new HashMap<>();
            for(i = 0; i < columns; i++){
                map.put(md.getColumnLabel(i + 1), getValueByType(rs, md.getColumnType(i + 1), md.getColumnLabel(i + 1)));
            }
            list.add(map);
        }
        return list;
    }
    private static Object getValueByType(ResultSet rs, int type, String name) throws SQLException{
        switch(type){
            case Types.NUMERIC:
                return rs.getLong(name);
            case Types.VARCHAR:
                return rs.getString(name);
            case Types.DATE:
                return rs.getDate(name);
            case Types.TIMESTAMP:
                return rs.getTimestamp(name).toString().substring(0,rs.getTimestamp(name).toString().length()-2);
            case Types.INTEGER:
                return rs.getInt(name);
            case Types.DOUBLE:
                return rs.getDouble(name);
            case Types.FLOAT:
                return rs.getFloat(name);
            case Types.BIGINT:
                return rs.getLong(name);
            default:
                return rs.getObject(name);
        }
    }
    public static void main(String[] args) {
        DataSource info = new DataSource();
        info.setDriver("com.mysql.cj.jdbc.Driver");
        info.setLinkUrl("jdbc:mysql://localhost:3306/edu?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        info.setLinkPwd("root");
        info.setLinkName("root");

        String sql = "SELECT\n" +
                "\ta.`name`,\n" +
                "\ta.total_t,\n" +
                "\tb.total_s\n" +
                "FROM\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\torganization_id,\n" +
                "\t\t\torg.`name`,\n" +
                "\t\t\tCOUNT(*) AS total_t\n" +
                "\t\tFROM\n" +
                "\t\t\torg_teacher os\n" +
                "\t\tLEFT JOIN t_organization org ON os.organization_id = org.id\n" +
                "\t\tGROUP BY\n" +
                "\t\t\torganization_id\n" +
                "\t) AS a\n" +
                "LEFT JOIN (\n" +
                "\tSELECT\n" +
                "\t\torganization_id,\n" +
                "\t\torg.`name`,\n" +
                "\t\tCOUNT(*) AS total_s\n" +
                "\tFROM\n" +
                "\t\torg_student os\n" +
                "\tLEFT JOIN t_organization org ON os.organization_id = org.id\n" +
                "\tGROUP BY\n" +
                "\t\torganization_id\n" +
                ") AS b ON a.organization_id = b.organization_id";

        List<Map<String,Object>> list = queryList(info,sql,null);
        System.out.println("data:"+ JSON.toJSONString(list));

    }
}
