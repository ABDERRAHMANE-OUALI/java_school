package com.mycompany.app;

import java.sql.*;

/**
 * MysqlDB
 */
public class MysqlDB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String host;
    private String username;
    private String password;

    public MysqlDB(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.host, this.username, this.password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public String Query(String query) {
        String queryResult = "";
        try {
            this.Connect();
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (resultSet.next()) {
                queryResult += resultSet.getString(1);
            }
            return queryResult;
        } catch (SQLException e) {
            return "";
        }
    }
}