/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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

      public static Connection gerSqlLiteConnection() throws IOException {
        try {
          
            Properties properties = commonUtility.getProperties();
            // db parameters
            String databasePath =  commonUtility.getApplicationPath() + "/application/storage/"+properties.getProperty("databaseName");
            String url =  properties.getProperty("databaseDrivers")+":"+databasePath;
           
            logger.log("create a connection to the database", applcationConstants.warning);
            // create a connection to the database
            conn = DriverManager.getConnection(url);
      
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
