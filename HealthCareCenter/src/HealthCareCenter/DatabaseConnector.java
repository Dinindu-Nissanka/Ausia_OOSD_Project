 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCareCenter;

//import com.mysql.jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DatabaseConnector {
    
    
    private Connection connector=null;
    
    public Connection getConnection(){
        
        System.out.println("=======MySql Connection Testing=======");
        
        try{
            Class.forName("com.mysql.jdbc.Connection");                  //checking for the driver
        }
        
        catch(ClassNotFoundException e) {
            System.out.println("Where is MySql Driver ???");
        }
        
        System.out.println("MySql Driver Registered");
        
        try{          //making the connection 
            connector=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:/FamilyDoctor?zeroDateTimeBehavior=convertToNull","root"," ");
            System.out.println("Connection Succeded!!!");
        }
        catch(SQLException e){
             System.out.println(e);
        }
        
   return connector;  //returning the connection
            
        
    }
    
}
