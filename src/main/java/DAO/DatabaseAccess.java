/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author M S I
 */
public class DatabaseAccess {
    private String DB_URL = "jdbc:mysql://localhost:3306/school";
    private String USERNAME = "root";
    private String PASSWORD = "";
    
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connect successfully");
            System.out.println("Database name: " + conn.getCatalog());
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return conn;
    }
}
