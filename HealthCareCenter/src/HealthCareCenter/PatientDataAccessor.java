/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCareCenter;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
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
                
                //myPatient=new Patient(name,age,NIC,familyName,gender,contactNo,specialRemarks);
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
    
    public void insertPatientData(){  //take the seven parameters
        
        //sqlQuery="INSERT INTO familydoctor.patient" + "(Name,Age,NIC,Gender,Family Name,Contact No.,Special Remarks)" + "VALUES" + "("+name+",....)";
        //stmnt.executUpdate(sqlQuery);
    }
}
