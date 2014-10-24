
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
    
    public List<Patient> retrievePatientData() throws SQLException{
        
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.patient";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
              
                name=dataSet.getString("Name");
                age=dataSet.getString("Age");
                ID=dataSet.getString("ID");
                gender=dataSet.getString("Gender");
                familyName=dataSet.getString("Family Name");
                contactNo=dataSet.getString("Contact No.");
                
                myPatient=new Patient(name,age,ID,familyName,gender,contactNo);
                patientList.add(myPatient);
            }
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
        
        return patientList;
    }
    
    public void insertPatientData(Patient myPatient) throws SQLException{  
        
                try {
            databaseConnector = myConnector.getConnection();
                 
            SQLQuery = "INSERT INTO familydoctor.patient "+"VALUES(?,?,?,?,?,?,?,?,?,?)";
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
    
     public ResultSet  retrieveDiagnoseStatistics(int ID) throws SQLException{
        
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.patient where ID="+ID;
            dataSet=stmnt.executeQuery(SQLQuery);
            
            return dataSet;
     }
     
     
}
