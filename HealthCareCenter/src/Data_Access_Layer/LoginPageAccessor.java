/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data_Access_Layer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pathum
 */
public class LoginPageAccessor {
      private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector myConnector=new DatabaseConnector();
   // private List<Patient> patientList=new ArrayList();
    private ResultSet dataSet=null;
   // private Patient myPatient=null;
    String SQLQuery=null;
    
    public ResultSet retrieveLoginPageData() throws SQLException{
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement)databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.loginpage";
            System.out.println(SQLQuery);
            dataSet=stmnt.executeQuery(SQLQuery);
            System.out.println(dataSet);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(stmnt!=null)
                stmnt.close();
            if(databaseConnector!=null)
                databaseConnector.close();
        }
        
        return dataSet;
    }

    
}
