/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCareCenter;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
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
    int age;
    String NIC;
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
                age=dataSet.getInt("Age");
                NIC=dataSet.getString("NIC");
                gender=dataSet.getString("Gender");
                familyName=dataSet.getString("Family Name");
                contactNo=dataSet.getString("Contact No.");
                specialRemarks=dataSet.getString("Special Remarks");
                
                myPatient=new Patient(name,age,NIC,familyName,gender,contactNo,specialRemarks);
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
            //stmnt = (Statement) databaseConnector.createStatement();

            SQLQuery = "INSERT INTO patientdetails (PatientID,Name,Address,telephone)"  + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setString(1, myPatient.getName());
            preparedStatement.setInt(2, myPatient.getAge());
            preparedStatement.setString(3, myPatient.getNIC());
            preparedStatement.setString(4, myPatient.getGender());
            preparedStatement.setString(5,myPatient.getFamilyName());
            preparedStatement.setString(6, myPatient.getContactNo());
            preparedStatement.setString(7, myPatient.getSpecialRemarks());
            preparedStatement.executeUpdate();
            
            //stmnt.executeUpdate(SQLQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"erroor");
        } finally {
            if (stmnt != null) {
                stmnt.close();
            }
            if (databaseConnector != null) {
                databaseConnector.close();
            }
        }
    }
}
