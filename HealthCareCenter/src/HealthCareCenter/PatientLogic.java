/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCareCenter;

import Business_Logic_Layer.Patient;
import Data_Access_Layer.PatientDataAccessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PatientLogic {
  
    PatientDataAccessor dataAccessor=new PatientDataAccessor();
    List<Patient> patientList= null;
    Patient myPatient=null;    
    ResultSet dataSet=null;
    
    public void setPatientDetails(String name,String familyName,String age,String gender,String contactNo) throws SQLException{
        myPatient=new Patient(name, age, "1",familyName, gender,contactNo);
        dataAccessor.insertPatientData(myPatient);
    }
    
    public String[] getNames() throws SQLException{
        
          
         patientList=dataAccessor.retrievePatientData();
      
         String[] nameArray=new String[patientList.size()];
          int i=0;
         for (Patient patientList1 : patientList) {
              myPatient = patientList1;
              nameArray[i]=myPatient.getName();
              i++;
    }
    
    return nameArray;
}
    public String[] getIDs() throws SQLException{
        
          
         patientList=dataAccessor.retrievePatientData();
      
         String[] IDArray=new String[patientList.size()];
          int i=0;
         for (Patient patientList1 : patientList) {
              myPatient = patientList1;
              IDArray[i]=myPatient.getID();
              i++;
    }
    
    return IDArray;
}
    
    public String[] getFamilyNames() throws SQLException{
        
          
         patientList=dataAccessor.retrievePatientData();
      
         String[] familyNameArray=new String[patientList.size()];
          int i=0;
         for (Patient patientList1 : patientList) {
              myPatient = patientList1;
              familyNameArray[i]=myPatient.getFamilyName();
              i++;
    }
    
    return familyNameArray;
}
    
    public String getHistory(int ID) throws SQLException {
         String history=null;
           dataSet=dataAccessor.retrieveDiagnoseStatistics(ID);
        
            if(dataSet==null)
                return "not yet diagnosed";
            else{
            while(dataSet.next())
              history= dataSet.getString("History");
             } 
             return history;
    }
    
    public String getPrescription(int ID) throws SQLException{
        String prescription = null;
        dataSet=dataAccessor.retrieveDiagnoseStatistics(ID);  
             if(dataSet==null)
                return "not yet diagnosed";
             else{
            while(dataSet.next())
              prescription= dataSet.getString("Prescription");
             }
             return prescription;
    }

    public String getBloodSugarLevel(int ID) throws SQLException{
            String sugarLevel = null;
         dataSet=dataAccessor.retrieveDiagnoseStatistics(ID);  
             if(dataSet==null)
                return "not yet diagnosed";
            else{
            while(dataSet.next())
              sugarLevel= dataSet.getString("Blood Sugar");
             }
             return sugarLevel;
    }
    
    public String getBloodPressureLevel(int ID) throws SQLException{
            String pressureLevel = null;
          dataSet=dataAccessor.retrieveDiagnoseStatistics(ID);  
             if(dataSet==null)
                return "not yet diagnosed";
             else{
            while(dataSet.next())
              pressureLevel= dataSet.getString("Blood Pressure");
             }
             return pressureLevel;
    }
    
    
}
    