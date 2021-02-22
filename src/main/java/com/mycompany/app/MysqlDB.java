package com.mycompany.app;

import java.sql.*;

/**
 * MysqlDB
 */
public class MysqlDB {
    public void Connect(String host, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(host, username, password);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}