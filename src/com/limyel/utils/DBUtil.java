package com.limyel.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/shutbb_servlet?useUnicode=true&characterEncoding=utf-8";
    private String username = "root";
    private String password = "107382+1s";
    private static DBUtil instance = null;
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    public static synchronized DBUtil getInstance() {
        if (instance == null) {
            instance = new DBUtil();
        }
        return instance;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public void releaseConn() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }

    /**
     * 增删改
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public boolean updateByPreparedStatement(String sql, List<Object> params) throws SQLException {
        int result;
        pstmt = connection.prepareStatement(sql);
        int index = 1;
        if (params != null && !params.isEmpty()) {
            for (Object i: params) {
                pstmt.setObject(index++, i);
            }
        }
        result = pstmt.executeUpdate();
        return result > 0;
    }

    /**
     * 查询一个
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public Map<String, Object> queryByPreparedStatement(String sql, List<Object> params) throws SQLException {
        Map<String, Object> result = new HashMap<>();
        pstmt = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            int index = 1;
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        resultSet = pstmt.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int colNum =metaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= colNum; i++) {
                String colName = metaData.getCatalogName(i);
                Object colValue = resultSet.getObject(colName);
                result.put(colName, colValue);
            }
        }
        return result;
    }

}
