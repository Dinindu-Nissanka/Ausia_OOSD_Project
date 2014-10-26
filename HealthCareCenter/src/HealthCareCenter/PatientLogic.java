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
    
    public List<Patient> getPatientDetails() throws SQLException{
        
        dataSet=dataAccessor.retrievePatientData();
        patientList=new ArrayList();
         while(dataSet.next()){
              
            String name = dataSet.getString("Name");
            String age = dataSet.getString("Age");
            String ID=dataSet.getString("ID");
            String gender = dataSet.getString("Gender");
            String familyName = dataSet.getString("Family Name");
            String contactNo = dataSet.getString("Contact No.");
                
                myPatient=new Patient(name,age,ID,familyName,gender,contactNo);
                patientList.add(myPatient);
            } 
         
         return patientList;
    }
    
    public String[] getNames() throws SQLException{
        
          
         dataSet=dataAccessor.retrievePatientData();
      
         String[] nameArray=new String[100];
          int i=0;
          while(dataSet.next()){
               nameArray[i]=dataSet.getString("Name");
               i++;
    }
    
    return nameArray;
}
    public String[] getIDs() throws SQLException{
        
          
         dataSet=dataAccessor.retrievePatientData();
      
         String[] IDArray=new String[100];
          int i=0;
         while(dataSet.next()){
               IDArray[i]=dataSet.getString("ID");
               i++;
    }
    
    return IDArray;
}
    
    public String[] getFamilyNames() throws SQLException{
        
          
         dataSet=dataAccessor.retrievePatientData();
      
         String[] familyNameArray=new String[100];
          int i=0;
         while(dataSet.next()){
               familyNameArray[i]=dataSet.getString("Family Name");
               i++;
    }
    
    return familyNameArray;
}
    
    public String getHistory(String name) throws SQLException {
         String history=null;
           dataSet=dataAccessor.retrievePatientStatistics(name);
        
            if(dataSet==null)
                return "not yet diagnosed";
            else{
            while(dataSet.next())
              history= dataSet.getString("History");
             } 
             return history;
    }
    
    public String getPrescription(String name) throws SQLException{
        String prescription = null;
        dataSet=dataAccessor.retrievePatientStatistics(name);  
             if(dataSet==null)
                return "not yet diagnosed";
             else{
            while(dataSet.next())
              prescription= dataSet.getString("Prescription");
             }
             return prescription;
    }

    public String getBloodSugarLevel(String name) throws SQLException{
            String sugarLevel = null;
         dataSet=dataAccessor.retrievePatientStatistics(name);  
             if(dataSet==null)
                return "not yet diagnosed";
            else{
            while(dataSet.next())
              sugarLevel= dataSet.getString("Blood Sugar");
             }
             return sugarLevel;
    }
    
    public String getBloodPressureLevel(String name) throws SQLException{
            String pressureLevel = null;
          dataSet=dataAccessor.retrievePatientStatistics(name);  
             if(dataSet==null)
                return "not yet diagnosed";
             else{
            while(dataSet.next())
              pressureLevel= dataSet.getString("Blood Pressure");
             }
             return pressureLevel;
    }
    public void updatePatientDetails(String name,String history,String medicineArray[],String quantityArray[],double sugarLevel,double pressureLevel) throws SQLException{
      //       
        String prescription ="";
        for(int i=0;i<10;i++){
            if(medicineArray[i]!=null && quantityArray[i]!=null )
            prescription=prescription+medicineArray[i]+" ~ "+quantityArray[i]+"\n";
            else break;
        }
        System.out.println(prescription);
        
        dataAccessor.updatePatientStatistics(name, history, prescription, sugarLevel, pressureLevel);
    }
    
}
    