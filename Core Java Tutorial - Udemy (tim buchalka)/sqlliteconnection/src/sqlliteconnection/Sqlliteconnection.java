/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlliteconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nilesh
 */
public class Sqlliteconnection {

/**
     * Connect to a sample database
     * @return 
     */
    public static  Connection conn = null;
    public Static Connection gerSqlLiteConnection() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Nilesh/Documents/NetBeansProjects/omSai/db/autoLoneManager.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
          
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("connection close");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
          return conn;
    }   
    
    public static void closeSqlLiteConnection(){
         try {
                if (conn != null) {
                    conn.close();
                    System.out.println("connection close");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
