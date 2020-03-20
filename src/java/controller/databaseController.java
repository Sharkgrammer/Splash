package controller;

import java.sql.*;

public class databaseController {

    //database details
    private final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final String DB_URL = "jdbc:derby://localhost:1527/colour";
    private final String USER = "shark";
    private final String PASS = "boopshark";
    public Connection conn;
    public String sql;
    public String error;
    public String lastEvent;

    public databaseController() {
        conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean isDatabaseAlive() {
        return conn != null;
    }

    public String returnSQL() {
        return sql;
    }

    public String returnError() {
        return error;
    }

    public void setLastEvent(String method){
        lastEvent = "\nLast SQL: " + sql + "\nLast Method: " + method + "\nLast Error: " + error;
    }
    
    public String returnLastEvent() {
        return lastEvent;
    }

}
