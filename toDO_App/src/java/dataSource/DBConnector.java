/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Magnus
 */
public class DBConnector {
     private static final String driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/toDo";
    private static final String id = "admin";			
    private static final String pw = "password";
    
    private Connection con;

    //-- Singleton ---- 
    private static DBConnector instance;
    private DBConnector()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);   // The connection will be released upon program 
		  					      // termination by the garbage collector	
        } catch (Exception e)
        {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }
    }
    public static DBConnector getInstance()
    {
        if (instance == null)
            instance = new DBConnector();
        return instance;
    }
    //------------------
    
    public Connection getConnection()
    {
      return con;
    }
}
