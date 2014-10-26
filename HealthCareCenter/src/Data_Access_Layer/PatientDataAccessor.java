
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import Business_Logic_Layer.Patient;
import Data_Access_Layer.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PatientDataAccessor {
    
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector myConnector=new DatabaseConnector();
    private List<Patient> patientList=new ArrayList();
    private ResultSet dataSet=null;
    private Patient myPatient=null;
    String SQLQuery=null;
    
    String name;
    String age;
    String ID;
    String gender;
    String familyName;
    String contactNo;
    String specialRemarks;
    
    public ResultSet retrievePatientData() throws SQLException{
        
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.patient";
            dataSet=stmnt.executeQuery(SQLQuery);
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return dataSet;
    }
    
    public void insertPatientData(Patient myPatient) throws SQLException{  
      
                try {
            databaseConnector = myConnector.getConnection();
                 
            SQLQuery = "INSERT INTO familydoctor.patient "+"VALUES(?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            
            preparedStatement.setString(1, myPatient.getName());
            preparedStatement.setString(2, myPatient.getAge());
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, myPatient.getGender());
            preparedStatement.setString(5,myPatient.getFamilyName());
            preparedStatement.setString(6, myPatient.getContactNo());
            preparedStatement.setString(7,null);
            preparedStatement.setString(8,null);
            preparedStatement.setString(9,null);
            preparedStatement.setString(10, null);
            preparedStatement.executeUpdate(); 
            
        } 
         catch (SQLException e) {
            System.out.println(e.getMessage());
          } 
          
         finally {
            if (stmnt != null) {
                stmnt.close();
            }
            if (databaseConnector != null) {
                databaseConnector.close();
            }
        }
    }
    
    public ResultSet browsePatientHistory(String nic) throws SQLException{
        
        try{
        databaseConnector=myConnector.getConnection();
        stmnt=(Statement) databaseConnector.createStatement();
        
        SQLQuery="SELECT * FROM familydoctor.patienthistory WHERE NIC="+nic;
        dataSet=stmnt.executeQuery(SQLQuery);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmnt != null) {
                stmnt.close();
            }
            if (databaseConnector != null) {
                databaseConnector.close();
            }
        }
        
        return dataSet; //return the raws as a resultSet
    }
    
    public ResultSet browseFamilyHistory(String familyname) throws SQLException{
        
        try{
        databaseConnector=myConnector.getConnection();
        stmnt=(Statement) databaseConnector.createStatement();
        
        SQLQuery="SELECT * FROM familydoctor.patienthistory WHERE Family Name="+familyname;
        dataSet=stmnt.executeQuery(SQLQuery);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmnt != null) {
                stmnt.close();
            }
            if (databaseConnector != null) {
                databaseConnector.close();
            }
        }
        
        return dataSet; //return the raws as a resultSet
    }
    
     public ResultSet  retrievePatientStatistics(String name) throws SQLException{
        
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT  * FROM familydoctor.patient WHERE Name= '"+name+"'" ;
            dataSet=stmnt.executeQuery(SQLQuery);
            
            return dataSet;
     }
     
     public void  updatePatientStatistics(String name,String history,String prescription,double sugarLevel,double pressureLevel) {
        
        try {
             databaseConnector=myConnector.getConnection();
        stmnt=(Statement) databaseConnector.createStatement();
        
        SQLQuery="UPDATE `familydoctor`.`patient` SET `History`="+history+" , `Prescription`="+prescription+" , `Blood Sugar`="+sugarLevel+" , `Blood Pressure`="+pressureLevel+" WHERE `Name`= "+name;
        stmnt.executeUpdate(SQLQuery);
            
            System.out.println(history);
            System.out.println(prescription);
            System.out.println(sugarLevel);
            System.out.println(pressureLevel);
            System.out.println(name);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientDataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
                 }
     
     
}
