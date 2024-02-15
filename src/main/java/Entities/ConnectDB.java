/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Ahmed yehia
 */
public class ConnectDB {
    private static Connection myconnection=null;
    
    public static Connection getConnect() throws FileNotFoundException, IOException, SQLException{
        if(myconnection==null){
              Properties prop=new Properties();
        prop.load(new FileInputStream("databaseConnection.Properties"));
        
        String user=prop.getProperty("user");
        String password=prop.getProperty("password");
        String dburl=prop.getProperty("dburl");
        myconnection = DriverManager.getConnection(dburl, user, password);
        }
        return myconnection;
    }
}
