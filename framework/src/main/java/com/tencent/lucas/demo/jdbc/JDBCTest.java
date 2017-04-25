package com.tencent.lucas.demo.jdbc;

import java.sql.*;

/**
 * Created by lucasfu on 2017/4/21.
 */
public class JDBCTest {

    static final String USER = "root";
    static final String PASS = "19891123";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/evening";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection conn = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * from evening_bonus_pool ";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("round_id");
                int qb = rs.getInt("qb");
                int huadou = rs.getInt("huadou");
                //Display values
                System.out.println("round: " + id + ",qb:" + qb + ",huadou:" + huadou);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public static void execute() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "SELECT * from evening_bonus_pool ";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("round_id");
                int qb = rs.getInt("qb");
                int huadou = rs.getInt("huadou");
                System.out.println("round: " + id + ",qb:" + qb + ",huadou:" + huadou);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

