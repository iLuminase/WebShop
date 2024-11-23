package com.phatlaptrinh.ShopLapTrinh.repository;

import java.sql.*;

public class LoginRepository {
    private String DB_URL = "jdbc:mysql://localhost:3306/springbootwebshop";
    private String USER = "root";
    private String PASS = "123123";
    public boolean checkLogin(String username, String password) {
        Boolean status = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stm = conn.createStatement();
            rs = stm.executeQuery(sql.toString());
            status = rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return status;
    }
}
